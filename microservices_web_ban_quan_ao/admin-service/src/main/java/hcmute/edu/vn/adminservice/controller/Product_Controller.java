package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.ProductMapper;
import hcmute.edu.vn.adminservice.api.v1.mapper.TypeMapper;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.service.Product_Service;
import hcmute.edu.vn.adminservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/product/")
@CrossOrigin(origins = "http://localhost:4200")
public class Product_Controller {
    @Autowired
    private Product_Service product_service;
    @Autowired
    private  Type_Service type_service;
    @Autowired
    private ProductMapper productMapper;
    @PostMapping("/editproduct")
    public Product editProduct(@RequestBody Product product){
        return product_service.editProduct(product);
    }
    @PostMapping("/addproduct/{id}")
    public Product_Dto addProduct(@RequestBody Product product, @PathVariable int id){
        Type type = type_service.findTypeById(id);
        product.setType(type);
        Product newProduct = product_service.addProduct(product);
        return product_service.mapperSingle(newProduct);
    }
    @DeleteMapping("deleteproduct/{productId}")
    public Product_Dto deleteProduct(@PathVariable int productId){
        return productMapper.productToProductDto(product_service.deleteProduct(productId));
    }
    @GetMapping("/products/{productID}")
    public Product_Dto findProductById(@PathVariable int productID){
        return productMapper.productToProductDto(product_service.findProductById(productID));
    }

    @GetMapping("/products")
    public List<Product_Dto> findAll(){
        return product_service.findAll().stream().map(productMapper::productToProductDto).collect(Collectors.toList());
    }

    @PostMapping("/editStatusproduct")
    public Product editProductStatus(@RequestBody int id){
        Product product1 = product_service.findProductById(id);
        if(product1.getStatus() == 1){
            product1.setStatus(0);
        } else
            product1.setStatus(1);
        return product_service.editProduct(product1);
    }
}
