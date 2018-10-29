package hcmute.edu.vn.guestservice.controller;


import hcmute.edu.vn.guestservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.guestservice.api.v1.mapper.DataReturnRecord;
import hcmute.edu.vn.guestservice.api.v1.mapper.User_Mapper;
import hcmute.edu.vn.guestservice.model.User;
import hcmute.edu.vn.guestservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/guest")
public class Guest_Controller {
    @Autowired
    private User_Service user_service;

    @Autowired
    private User_Mapper user_mapper;

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

}
