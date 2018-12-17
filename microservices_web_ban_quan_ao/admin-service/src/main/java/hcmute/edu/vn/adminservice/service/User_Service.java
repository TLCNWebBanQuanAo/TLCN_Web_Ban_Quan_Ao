package hcmute.edu.vn.adminservice.service;


import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;

import java.util.List;

public interface User_Service {
    User editUser(User user);
    User deleteUser(int Id);
    User findUserById(int Id);
    List<User> findAll();
}
