package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.repository.Product_Repository;
import hcmute.edu.vn.userservice.service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService_Impl implements Product_Service {
    @Autowired
    private Product_Repository product_repository;
    @Override
    public Product editProduct(Product product) {
        if(product == null)
            throw new NotFoundException("Sua gia khong thanh cong !!!");
        return product_repository.save(product);
    }
    @Override
    public Product FindProductById(int id){
        Optional<Product> product = product_repository.findById(id);
        if(!product.isPresent())
            throw new NotFoundException("Product does not exist !");
        return product.get();
    }
    @Override
    public Page<Product> findAllProductPaging(Optional<Integer> id ,Optional<String> keyword, Optional<Integer> page, Optional<Integer> size) {
        Page<Product> productPage = null;

        if(id.get() == 0 || id.get() == null)
            productPage = product_repository.findAllProductsPaging(keyword.orElse(""),
                    new PageRequest(page.orElse(0),size.orElse(12), Sort.Direction.ASC,"id"));
        else
            productPage = product_repository.findAllProductsByCategoryPaging(id.get(), keyword.orElse(""),
                    new PageRequest(page.orElse(0),size.orElse(12), Sort.Direction.ASC,"id"));
        if(productPage.getContent().isEmpty())
            throw new NotFoundException("Not found any products !!!");
        return productPage;
    }

}
