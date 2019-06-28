package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.model.Bill_History;
import hcmute.edu.vn.userservice.model.Order;
import hcmute.edu.vn.userservice.model.User;
import hcmute.edu.vn.userservice.repository.Bill_Repository;
import hcmute.edu.vn.userservice.repository.User_Repository;
import hcmute.edu.vn.userservice.service.Bill_Service;
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
    public Bill AddBill (Bill bill){
        return bill_repository.save(bill);
    }

     @Override
    public Bill FindBillById( int id){
         Optional<Bill> bill = bill_repository.findById(id);
         if (!bill.isPresent())
             throw new NotFoundException("Bill does not exist!.");
         return bill.get();
     }

     @Override
    public List<Bill> Bill_List(){
        return bill_repository.findAll();
     }

    @Override
    public List<Bill> findAllByUser(String accountName) {

        Optional<User> user = user_repository.findUserByAccountName(accountName);
        if(!user.isPresent())
            throw new NotFoundException("Not Found User ???");

        List<Bill> bill = bill_repository.findAllByUser(user.get());

        if(bill.isEmpty())
            throw new NotFoundException("Not Found Invoice ???");

        return bill;
    }

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
            temp.setBill_id(Integer.valueOf(temps.get(i)[6].toString()));
            orderArrayList.add(temp);
        }
        return orderArrayList;
    }

}
