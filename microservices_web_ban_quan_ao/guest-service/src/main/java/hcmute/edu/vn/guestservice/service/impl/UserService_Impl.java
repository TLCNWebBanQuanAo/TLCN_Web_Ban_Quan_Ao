package hcmute.edu.vn.guestservice.service.impl;

import hcmute.edu.vn.guestservice.model.Cart;
import hcmute.edu.vn.guestservice.model.User;
import hcmute.edu.vn.guestservice.repository.Cart_Repository;
import hcmute.edu.vn.guestservice.repository.User_Repository;
import hcmute.edu.vn.guestservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService_Impl implements User_Service {
    @Autowired
    private User_Repository user_repository;

    @Autowired
    private Cart_Repository cart_repository;

    @Override
    public User registerUser(User user){
        User userCreate = user_repository.save(user);
        Cart cart = new Cart();
        cart.setUser(userCreate);
        Cart cartCreate = cart_repository.save(cart);
        userCreate.setCart(cartCreate);

        return user_repository.save(userCreate);
    }

    @Override
    public User checkAccount (String accountname){
        Optional<User> account = user_repository.findByAccountName(accountname);
        if(!account.isPresent())
            return null;
        return account.get();
    }

    @Override
    public User checkLogin(String accountname, String password){
        Optional<User> account = user_repository.findByAccountNameAndPassword(accountname, password);
        if(!account.isPresent())
            return null;
        return account.get();
    }

}