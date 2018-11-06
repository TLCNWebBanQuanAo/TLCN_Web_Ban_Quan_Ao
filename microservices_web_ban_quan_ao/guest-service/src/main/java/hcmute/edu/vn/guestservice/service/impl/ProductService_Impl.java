package hcmute.edu.vn.guestservice.service.impl;

import hcmute.edu.vn.guestservice.exception.NotFoundException;
import hcmute.edu.vn.guestservice.model.Product;
import hcmute.edu.vn.guestservice.repository.Product_Repository;
import hcmute.edu.vn.guestservice.service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService_Impl implements Product_Service {
    @Autowired
    private Product_Repository product_repository;

    @Override
    public Product findById(long id) {
        Optional<Product> product = product_repository.findById(id);
        if(!product.isPresent())
            throw new NotFoundException("Không tìm thấy sản phẩm !!!");
        return product.get();
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> products = product_repository.findAll();
        if (products.isEmpty())
            throw new NotFoundException("Không có sản phẩm nào !!!");
        return products;
    }
}
