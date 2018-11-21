package hcmute.edu.vn.userservice.controller;

import hcmute.edu.vn.userservice.api.v1.DataReturnList;
import hcmute.edu.vn.userservice.api.v1.DataReturnRecord;
import hcmute.edu.vn.userservice.api.v1.dto.Bill_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.CartDetail_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.userservice.api.v1.mapper.Bill_Mapper;
import hcmute.edu.vn.userservice.api.v1.mapper.CartDetail_Mapper;
import hcmute.edu.vn.userservice.api.v1.mapper.User_Mapper;
import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.model.Cart;
import hcmute.edu.vn.userservice.model.User;
import hcmute.edu.vn.userservice.service.Bill_Service;
import hcmute.edu.vn.userservice.service.CartDetail_Service;
import hcmute.edu.vn.userservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user/")
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
    public DataReturnRecord<User_Dto> getUser(@PathVariable String accountname){
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

}
