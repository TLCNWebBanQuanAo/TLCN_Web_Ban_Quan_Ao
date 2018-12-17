package hcmute.edu.vn.adminservice.service;


import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;

import java.util.List;

public interface Product_Service {
    Product addProduct(Product product);
    Product editProduct(Product product);
    Product deleteProduct(int Id);
    Product findProductById(int Id);
    List<Product> findAll();
}
