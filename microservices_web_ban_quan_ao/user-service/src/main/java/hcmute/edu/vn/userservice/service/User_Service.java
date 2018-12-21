package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface User_Service {
    User ChangePassword (User user);
    User FindByAccountNameAndPassword ( String accountName, String password);
    User ChangePersonalInformation (User user);
    User FindByAccountName(String accountName);

}
