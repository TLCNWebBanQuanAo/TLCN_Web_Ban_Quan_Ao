package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.User;

public interface User_Service {
    User ChangePassword (User user);
    User FindByAccountNameAndPassword ( String accountname, String password);
    User ChangePersonalInformation (User user);
    User FindByAccountName(String accountname);
}
