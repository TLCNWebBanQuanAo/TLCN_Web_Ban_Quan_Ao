package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.model.Bill;
import hcmute.edu.vn.adminservice.model.Order;
import hcmute.edu.vn.adminservice.repository.Bill_Repository;
import hcmute.edu.vn.adminservice.repository.User_Repository;
import hcmute.edu.vn.adminservice.service.Bill_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService_Impl implements Bill_Service {
    @Autowired
    private Bill_Repository bill_repository;
    @Autowired
    private User_Repository user_repository;

    @Override
    public List<Order> getAllOrder() {
        List<Object[]> temps = bill_repository.getAllOrder();
        List<Order> orderArrayList = new ArrayList<>();
        for (int i = 0; i < temps.size(); i++) {
            Order temp = new Order();
            temp.setId(Integer.valueOf(temps.get(i)[0].toString()));
            temp.setName(String.valueOf(temps.get(i)[1]));
            temp.setEmail(String.valueOf(temps.get(i)[2]));
            temp.setAddress(String.valueOf(temps.get(i)[3]));
            temp.setPhone(String.valueOf(temps.get(i)[4]));
            temp.setDateCreate((Date)temps.get(i)[5]);
            temp.setStatus(Integer.valueOf(temps.get(i)[6].toString()));
            temp.setBill_id(Integer.valueOf(temps.get(i)[7].toString()));
            orderArrayList.add(temp);
        }
        return orderArrayList;
    }

    @Override
    public Bill updateStatus(int id, String userUpdate) {
        Optional<Bill> billOptional = bill_repository.findById(id);
        Bill bill = billOptional.get();
        if(bill.getStatus() == 0)
            bill.setStatus(1);
        bill.setDateUpdate(new Date());
        bill.setUserUpdate(userUpdate);
        return bill_repository.save(bill);
    }
}
