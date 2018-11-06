package hcmute.edu.vn.guestservice.service;

import hcmute.edu.vn.guestservice.model.Product;

import java.util.List;

public interface Product_Service {
    Product findById(long id);
    List<Product> findAllProduct();
}
