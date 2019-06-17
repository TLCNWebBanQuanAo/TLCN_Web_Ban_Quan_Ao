package hcmute.edu.vn.adminservice.service;


import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;

import java.util.List;

public interface Product_Service {
    Product_Dto mapperSingle(Product product);
    List<Product_Dto> mapperArray(List<Product> products);
    Product addProduct(Product product);
    Product editProduct(Product product);
    Product deleteProduct(int Id);
    Product findProductById(int Id);
    List<Product> findAll();
    Product toProduct(Product_Dto productDTO);
}
