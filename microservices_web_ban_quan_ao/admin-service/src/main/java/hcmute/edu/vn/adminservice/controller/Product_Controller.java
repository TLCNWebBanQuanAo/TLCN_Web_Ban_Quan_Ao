package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.ProductMapper;
import hcmute.edu.vn.adminservice.api.v1.mapper.TypeMapper;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.Wishlist;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.repository.Wishlist_Repository;
import hcmute.edu.vn.adminservice.service.ContactService;
import hcmute.edu.vn.adminservice.service.Product_Service;
import hcmute.edu.vn.adminservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.mail.MessagingException;

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
    @Autowired
    private ContactService contactService;

    @Autowired
    private Wishlist_Repository wishlist_repository;

    private static String adminEmailAddress = "dandm.shop.97@gmail.com";

    @PostMapping("/editproduct")
    public  Product_Dto editProduct(@RequestBody Product product){
        //Product updateProduct = product_service.toProduct(product);
        Double current_price = product.getPrice();
        List<Wishlist> wishlists = wishlist_repository.findAllByProduct_Id(product.getId());
        for (Wishlist wishlist: wishlists) {
            if(wishlist.getDealPrice() >= current_price &&
                    product.getId() == wishlist.getWishlist_id().getProduct().getId() &&
                    wishlist.getWishlist_id().getUser().getEmail() != ""){
                String toAddress = wishlist.getWishlist_id().getUser().getEmail();
                String subject = "Giá tốt cho bạn";
                String content = "";
                content += "Sản phẩm bạn muốn mua đã giảm còn : " + current_price + "$. ";
                //content += "You can get more detail of product at : http://localhost:4200/productdetail/"+product.getId()+"/1";
                try{
                    contactService.send(adminEmailAddress,toAddress, subject, content);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        Product saveproduct= product_service.editProduct(product);
        //System.out.println(updateProduct.getName());
        return product_service.mapperSingle(saveproduct);
        //return ResponseEntity.ok(product_service.editProduct(updateProduct));
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
