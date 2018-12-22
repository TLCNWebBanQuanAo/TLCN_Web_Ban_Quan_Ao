package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.exception.NotFoundException;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;
import hcmute.edu.vn.adminservice.repository.User_Repository;
import hcmute.edu.vn.adminservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSerVice_Impl implements User_Service {
    @Autowired
    private User_Repository user_repository;


    @Override
    public User editUser(User user) {
        if(user == null)
            throw new NotFoundException("Sua user khong thanh cong !!!");
        return user_repository.save(user);
    }

    @Override
    public User deleteUser(int Id) {
        Optional<User> user = user_repository.findById(Id);
        user_repository.delete(user.get());
        return user.get();
    }

    @Override
    public User findUserById(int Id) {
        Optional<User> user = user_repository.findById(Id);
        if (!user.isPresent())
            throw new NotFoundException("Not Found User");
        return user.get();
    }

    @Override
    public List<User> findAll() {
        return user_repository.findAll();
    }
}




