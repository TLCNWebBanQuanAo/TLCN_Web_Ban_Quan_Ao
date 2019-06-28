package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.model.Order;

import java.util.List;

public interface Bill_Service {
    Bill AddBill(Bill bill);
    Bill FindBillById(int id);
    List<Bill> Bill_List();
    List<Bill> findAllByUser(String accountName);
    List<Order> getAllOrder();
}
