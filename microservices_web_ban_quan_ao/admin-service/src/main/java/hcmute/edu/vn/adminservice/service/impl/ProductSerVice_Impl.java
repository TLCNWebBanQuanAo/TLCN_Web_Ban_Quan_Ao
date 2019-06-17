package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.ProductMapper;
import hcmute.edu.vn.adminservice.exception.NotFoundException;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.repository.Product_Repository;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.service.Product_Service;
import hcmute.edu.vn.adminservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProductSerVice_Impl implements Product_Service {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private Product_Repository product_repository;


    @Override
    public Product_Dto mapperSingle(Product product) {
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<Product_Dto> mapperArray(List<Product> products) {
        return products.stream().map(productMapper::productToProductDto).collect(Collectors.toList());
    }

    @Override
    public Product addProduct(Product product) {
        if(product == null)
            throw new NotFoundException("Them mat hang khong thanh cong !!!");
        return product_repository.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        if(product == null)
            throw new NotFoundException("Sua mat hang khong thanh cong !!!");
        return product_repository.save(product);
    }

    @Override
    public Product deleteProduct(int Id) {
        Optional<Product> product = product_repository.findById(Id);
        product_repository.delete(product.get());
        return product.get();
    }

    @Override
    public Product findProductById(int Id) {
        Optional<Product> product = product_repository.findById(Id);
        if (!product.isPresent())
            throw new NotFoundException("Not Found User");
        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return product_repository.findAll();
    }

    @Override
    public Product toProduct(Product_Dto productDTO) {

        Product product = new Product();

        if (productDTO.getId() != 0){
            product = product_repository.findById(productDTO.getId()).get();
        }else{
            product.setDateCreate(new Date());
        }
        product.setDateUpdate(new Date());
        product.setStatus(productDTO.getStatus());
        product.setName(productDTO.getName());
        product.setUserCreate("admin");
        product.setUserUpdate("admin");
        product.setImages(productDTO.getImages());
        product.setPrice(productDTO.getPrice());

        return product;
    }

}




