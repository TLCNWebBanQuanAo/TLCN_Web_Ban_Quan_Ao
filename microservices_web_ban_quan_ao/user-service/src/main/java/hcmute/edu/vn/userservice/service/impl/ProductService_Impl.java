package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.repository.Product_Repository;
import hcmute.edu.vn.userservice.service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService_Impl implements Product_Service {
    @Autowired
    private Product_Repository product_repository;

    @Override
    public Product FindProductById(int id){
        Optional<Product> product = product_repository.findById(id);
        if(!product.isPresent())
            throw new NotFoundException("Product does not exist !");
        return product.get();
    }

}
