package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface Product_Service {
    Product FindProductById(int id);
    Page<Product> findAllProductPaging(Optional<Integer> id ,Optional<String> keyword, Optional<Integer> page, Optional<Integer> size);
}
