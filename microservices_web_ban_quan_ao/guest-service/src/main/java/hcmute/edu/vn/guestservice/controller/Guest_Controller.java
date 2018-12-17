package hcmute.edu.vn.guestservice.controller;


import hcmute.edu.vn.guestservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.guestservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.guestservice.api.v1.mapper.DataReturnList;
import hcmute.edu.vn.guestservice.api.v1.mapper.DataReturnRecord;
import hcmute.edu.vn.guestservice.api.v1.mapper.Product_Mapper;
import hcmute.edu.vn.guestservice.api.v1.mapper.User_Mapper;
import hcmute.edu.vn.guestservice.model.Product;
import hcmute.edu.vn.guestservice.model.User;
import hcmute.edu.vn.guestservice.service.Product_Service;
import hcmute.edu.vn.guestservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/guest")
@CrossOrigin(origins = "http://localhost:4200")
public class Guest_Controller {
    @Autowired
    private User_Service user_service;

    @Autowired
    private User_Mapper user_mapper;

    @Autowired
    private Product_Service product_service;

    @Autowired
    private Product_Mapper product_mapper;

   @PostMapping("/register")
    public DataReturnRecord<User_Dto> register(@RequestBody User user){
       User testUser = user_service.checkAccount(user.getAccountName());

       DataReturnRecord<User_Dto> dtoDataReturnRecord = new DataReturnRecord<>();

       if(testUser != null){
           dtoDataReturnRecord.setMessage("Tai khoan da ton tai !!!");
           dtoDataReturnRecord.setSuccess("fale");
       }

       else {
           Date date = new Date();
           user.setDateCreate(date);
           user.setDateUpdate(date);
           user.setUserCreate(user.getAccountName());
           user.setUserUpdate(user.getAccountName());
           user.setStatus(1);
           dtoDataReturnRecord.setMessage("Tao tai khoan thanh cong !!!");
           dtoDataReturnRecord.setSuccess(("true"));
           dtoDataReturnRecord.setData(user_mapper.userToUserDto(user_service.registerUser(user)));
       }
        return dtoDataReturnRecord;
    }

    @PostMapping("/login/{accountname}/{password}")
    public DataReturnRecord<User_Dto> login(@PathVariable String accountname, @PathVariable String password){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User user = user_service.checkLogin(accountname, password);
        if(user == null){
            dataReturnRecord.setMessage("Sai tai khoan hoac mat khau !!!");
            dataReturnRecord.setSuccess("false");
        }
        else {
            dataReturnRecord.setMessage("Dang nhap thanh cong !!!");
            dataReturnRecord.setSuccess("true");
            dataReturnRecord.setData(user_mapper.userToUserDto(user));
        }

        return dataReturnRecord;
    }

    @GetMapping("/products")
    public DataReturnList<Product_Dto> getAllProduct(){
        DataReturnList<Product_Dto> dataReturnList = new DataReturnList<>();
        List<Product> products = product_service.findAllProduct();
        if(products.isEmpty()){
            dataReturnList.setMessage("Danh sách rỗng !!!");
            dataReturnList.setSuccess("false");
        }
        else {
            dataReturnList.setMessage("Get All Products");
            dataReturnList.setSuccess("true");
            dataReturnList.setData(products.stream().map(product_mapper::productToProductDto).collect(Collectors.toList()));
        }

        return dataReturnList;
    }

    @GetMapping("/product/{productId}")
    public DataReturnRecord<Product_Dto> getProductById(@PathVariable long productId){
        DataReturnRecord<Product_Dto> dataReturnRecord = new DataReturnRecord<>();
        Product product = product_service.findById(productId);

        if(product == null){
            dataReturnRecord.setMessage("Không tìm thấy sản phẩm !!!");
            dataReturnRecord.setSuccess("false");
        }else{
            dataReturnRecord.setMessage("Get Product By Id");
            dataReturnRecord.setSuccess("true");
            dataReturnRecord.setData(product_mapper.productToProductDto(product));
        }

        return dataReturnRecord;
    }

}
