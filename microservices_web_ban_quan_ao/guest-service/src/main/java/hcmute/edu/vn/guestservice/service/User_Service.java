package hcmute.edu.vn.guestservice.service;

import hcmute.edu.vn.guestservice.model.User;

public interface User_Service {
    User registerUser(User user);
    User checkAccount(String accountname);
    User checkLogin(String accountname, String password);
}