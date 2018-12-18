package hcmute.edu.vn.userservice.controller;

import hcmute.edu.vn.userservice.api.v1.DataReturnList;
import hcmute.edu.vn.userservice.api.v1.DataReturnRecord;
import hcmute.edu.vn.userservice.api.v1.dto.Bill_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.CartDetail_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.userservice.api.v1.mapper.Bill_Mapper;
import hcmute.edu.vn.userservice.api.v1.mapper.CartDetail_Mapper;
import hcmute.edu.vn.userservice.api.v1.mapper.Product_Mapper;
import hcmute.edu.vn.userservice.api.v1.mapper.User_Mapper;
import hcmute.edu.vn.userservice.model.*;
import hcmute.edu.vn.userservice.repository.Product_Repository;
import hcmute.edu.vn.userservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class User_Controller {
    @Autowired
    private User_Service user_service;

    @Autowired
    private User_Mapper user_mapper;

    @Autowired
    private Bill_Service bill_service;

    @Autowired
    private Bill_Mapper bill_mapper;

    @Autowired
    private CartDetail_Service cartDetail_service;

    @Autowired
    private CartDetail_Mapper cartDetail_mapper;

    @Autowired
    private Product_Service product_service;

    @Autowired
    private Product_Mapper product_mapper;

    @Autowired
    private BillDetail_Service billDetail_service;

    @PostMapping("/changeavatar")
    public DataReturnRecord<User_Dto> changeavatar(@RequestBody User user){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User usertemp= user_service.FindByAccountName(user.getAccountName());
        usertemp.setAvatar(user.getAvatar());
        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePassword(usertemp)));
        dataReturnRecord.setMessage("Change Avatar successfully !!!");
        return dataReturnRecord;
    }

    @PostMapping("/changepassword/{accountname}/{oldpassword}/{newpassword}")
    public DataReturnRecord<User_Dto> ChangePassWord(@PathVariable String accountname,
                                                     @PathVariable String oldpassword, @PathVariable String newpassword){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User user = user_service.FindByAccountNameAndPassword(accountname, oldpassword);
        dataReturnRecord.setMessage("Change password successfully.");
        user.setPassword(newpassword);
        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePassword(user)));

        return dataReturnRecord;
    }

    @PostMapping("/changepersonalinformation")
    public DataReturnRecord<User_Dto> ChangePersonalInformation(@RequestBody User user){

        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User user1 = user_service.FindByAccountName(user.getAccountName());
        Date date = new Date();

        user1.setUserUpdate(user1.getAccountName());
        user1.setDateUpdate(date);
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setDateOfBirth(user.getDateOfBirth());
        user1.setGender(user.getGender());

        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePersonalInformation(user1)));
        dataReturnRecord.setMessage("Change personal information successfully.");

        return dataReturnRecord;
    }

    @GetMapping("/{accountname}")
    public DataReturnRecord<User_Dto> GetUser(@PathVariable String accountname){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();

        User user = user_service.FindByAccountName(accountname);
        dataReturnRecord.setMessage("Get User By User Name");
        dataReturnRecord.setData(user_mapper.UserToUserDto(user));

        return dataReturnRecord;
    }

    @GetMapping("/getbill/{id}")
    public DataReturnRecord<Bill_Dto> GetBill(@PathVariable int id){
        DataReturnRecord<Bill_Dto> dataReturnRecord = new DataReturnRecord<>();
        Bill bill = bill_service.FindBillById(id);
        dataReturnRecord.setMessage("Get Bill By Id");
        dataReturnRecord.setData(bill_mapper.BillToBillDto(bill));
        return dataReturnRecord;

    }

    @GetMapping("/getbilllist")
    public DataReturnList<Bill_Dto> GetBillList() {
        DataReturnList<Bill_Dto> dataReturnList = new DataReturnList<>();
        List<Bill> bills = bill_service.Bill_List();
        if (bills.isEmpty()){
            dataReturnList.setMessage("Your bills does not exist !");
            dataReturnList.setSuccess("false");
        }
        else {
            dataReturnList.setMessage("Get all your bills");
            dataReturnList.setData(bills.stream().map(bill_mapper::BillToBillDto).collect(Collectors.toList()));
        }
        return dataReturnList;
    }

    @GetMapping("/getproductincart/{accountname}")
    public DataReturnList<CartDetail_Dto> GetProductInCart(@PathVariable String accountname){
        Cart cart = user_service.FindByAccountName(accountname).getCart();
        DataReturnList<CartDetail_Dto> dataReturnList = new DataReturnList<>();
        dataReturnList.setData(cartDetail_service.RetrieveAllProductInCart(cart.getId())
                .stream()
                .map(cartDetail_mapper::CartDetailToCartDetailDto)
                .collect(Collectors.toList()));
        dataReturnList.setMessage("Get all product in cart");
        return dataReturnList;
    }

    @PostMapping("/addproductincart/{accountname}/{productid}/{quantity}")
    public DataReturnRecord<CartDetail_Dto> AddProductInCart (@PathVariable String accountname,
                                                              @PathVariable int productid, @PathVariable int quantity){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        cart_detail.setQuantity(quantity);

        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Add products successful.");
        return dataReturnRecord;
    }

    @DeleteMapping("/deleteproductincart/{accountname}/{productid}")
    public DataReturnRecord<Product_Dto> DeleteProductInCart(@PathVariable String accountname, @PathVariable int productid){
        DataReturnRecord<Product_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id(cart,product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);

        cartDetail_service.DeleteProductInCart(cart_detail);

        dataReturnRecord.setMessage("Delete Product Successfully.");
        dataReturnRecord.setData(product_mapper.ProductToProductDto(product));

        return dataReturnRecord;
    }

    @DeleteMapping("/deleteallproductincart/{accountname}")
    public boolean DeleteAllProductInCart(@PathVariable String accountname){
        Cart cart = user_service.FindByAccountName(accountname).getCart();
        return cartDetail_service.DeleteAllProductInCart(cart.getId());
    }

    @PostMapping("/payment/{accountname}")
    public boolean Payment (@PathVariable String accountname){
        User user = user_service.FindByAccountName(accountname);

        Date date = new Date();
        String address;

        Bill bill = new Bill();
        bill.setTotal(Double.valueOf(0));
        bill.setAddress("");
        bill.setPhone(Integer.valueOf(0));
        bill.setStatus(Integer.valueOf(0));
        bill.setDateCreate(date);
        bill.setDateUpdate(date);
        bill.setUserCreate(accountname);
        bill.setUserUpdate(accountname);
        bill.setUser(user);

        Bill addbill = bill_service.AddBill(bill);
        System.out.println(addbill.getId());
        Cart cart = user.getCart();
        List<Cart_Detail> cart_details = cartDetail_service.RetrieveAllProductInCart(cart.getId());

        List<Bill_Detail> bill_details = new ArrayList<>();

        for (Cart_Detail cart_detail: cart_details) {
            Bill_Product_Id bill_product_id = new Bill_Product_Id();
            bill_product_id.setBill(addbill);
            bill_product_id.setProduct(cart_detail.getId().getProduct());

            Bill_Detail bill_detail = new Bill_Detail();
            bill_detail.setId(bill_product_id);
            bill_detail.setPrice(cart_detail.getId().getProduct().getPrice());
            bill_detail.setQuantity(cart_detail.getQuantity());

            bill_details.add(billDetail_service.AddBillProduct(bill_detail));
        }

        return cartDetail_service.DeleteAllProductInCart(cart.getId());
    }



}
