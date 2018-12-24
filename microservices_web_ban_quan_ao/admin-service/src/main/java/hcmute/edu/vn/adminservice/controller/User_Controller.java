package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.TypeMapper;
import hcmute.edu.vn.adminservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;
import hcmute.edu.vn.adminservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/v1/admin/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class User_Controller {
    @Autowired
    private User_Service user_service;
    @Autowired
    private UserMapper userMapper;

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

}
