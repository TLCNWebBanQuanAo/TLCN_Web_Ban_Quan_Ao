package hcmute.edu.vn.adminservice.service;

import hcmute.edu.vn.adminservice.model.Bill;
import hcmute.edu.vn.adminservice.model.Order;

import java.util.List;

public interface Bill_Service {
    List<Order> getAllOrder();
    Bill updateStatus(int id, String userName);
}
