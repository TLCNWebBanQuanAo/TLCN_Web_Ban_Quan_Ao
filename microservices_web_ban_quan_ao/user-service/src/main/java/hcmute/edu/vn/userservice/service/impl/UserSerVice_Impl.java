package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.User;
import hcmute.edu.vn.userservice.repository.User_Repository;
import hcmute.edu.vn.userservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSerVice_Impl implements User_Service {
    @Autowired
    private User_Repository user_repository;

    @Override
    public User ChangePassword(User user) {
        return  user_repository.save(user);
    }

    @Override
    public User FindByAccountNameAndPassword (String accountname, String password){
        Optional<User> user = user_repository.FindByAccountNameAndPassword(accountname, password);
        if (!user.isPresent())
            throw  new NotFoundException("Account does not exist!.");
        return user.get();
    }

    @Override
    public User ChangePersonalInformation(User user){
        return user_repository.save(user);
    }

    @Override
    public User FindByAccountName(String accountname){
        Optional<User> user = user_repository.FindByAccountName(accountname);
        if (!user.isPresent())
            throw new NotFoundException("Account does not exist!.");
        return user.get();
    }
}




