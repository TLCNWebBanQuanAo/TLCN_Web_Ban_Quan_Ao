package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.DataReturnList;
import hcmute.edu.vn.adminservice.api.v1.DataReturnOne;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.adminservice.model.Bill;
import hcmute.edu.vn.adminservice.model.Bill_History;
import hcmute.edu.vn.adminservice.model.Order;
import hcmute.edu.vn.adminservice.model.User;
import hcmute.edu.vn.adminservice.service.BillDetail_Service;
import hcmute.edu.vn.adminservice.service.Bill_Service;
import hcmute.edu.vn.adminservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("admin/user")
@CrossOrigin(origins = "http://localhost:4200")
public class User_Controller {
    @Autowired
    private User_Service user_service;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Bill_Service bill_service;
    @Autowired
    private BillDetail_Service billDetail_service;

    @PostMapping("/edituser")
    public User editUser(@RequestBody int id){
        User user = user_service.findUserById(id);
        if(user.getStatus() == 1){
            user.setStatus(2);
        }
        else if(user.getStatus() == 2){
            user.setStatus(1);
        }
        return user_service.editUser(user);
    }
    @DeleteMapping("deleteuser/{userId}")
    public User_Dto deleteUser(@PathVariable int userId){
        return userMapper.userToUserDto(user_service.deleteUser(userId));
    }
    @GetMapping("/users/{userID}")
    public User_Dto findUserById(@PathVariable int userID){
        return userMapper.userToUserDto(user_service.findUserById(userID));
    }

    @GetMapping("/users")
    public List<User_Dto> findAll(){
        return user_service.findAll().stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }

    @GetMapping("/detailBill/{bill_id}")
    public DataReturnList<Bill_History> getBillHistory(@PathVariable Long bill_id) {
        DataReturnList<Bill_History> dataReturnList = new DataReturnList<>();
        dataReturnList.setSuccess("true");
        dataReturnList.setMessage("success");
        dataReturnList.setData(billDetail_service.detailBillById(bill_id));
        return dataReturnList;
    }

    @GetMapping("/order")
    public DataReturnList<Order> getAllOrder() {
        DataReturnList<Order> dataReturnList = new DataReturnList<>();
        dataReturnList.setSuccess("true");
        dataReturnList.setMessage("success");
        dataReturnList.setData(bill_service.getAllOrder());
        return dataReturnList;
    }

    @GetMapping("/order/update/{id}/{userUpdate}")
    public DataReturnOne<Bill> UpdateItems(@PathVariable int id, @PathVariable String userUpdate){
        Bill bill = bill_service.updateStatus(id, userUpdate);
        DataReturnOne<Bill> dataReturnOne = new DataReturnOne<>();
        if(bill != null){
            dataReturnOne.setData(bill);
            dataReturnOne.setMessage("Update status success");
            dataReturnOne.setSuccess("true");
        }else{
            dataReturnOne.setSuccess("false");
            dataReturnOne.setData(null);
            dataReturnOne.setMessage("Update status fail");
        }
        return dataReturnOne;
    }

}
