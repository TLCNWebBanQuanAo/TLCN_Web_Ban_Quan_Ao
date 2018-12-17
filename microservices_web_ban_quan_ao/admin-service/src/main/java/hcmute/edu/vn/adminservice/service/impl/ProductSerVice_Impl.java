package hcmute.edu.vn.adminservice.service.impl;

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

@Service
public class ProductSerVice_Impl implements Product_Service {
    @Autowired
    private Product_Repository product_repository;


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
}




