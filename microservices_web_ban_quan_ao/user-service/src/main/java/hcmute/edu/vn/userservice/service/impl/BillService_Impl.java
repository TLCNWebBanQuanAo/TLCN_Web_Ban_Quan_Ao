package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.repository.Bill_Repository;
import hcmute.edu.vn.userservice.service.Bill_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService_Impl implements Bill_Service {
    @Autowired
    private Bill_Repository bill_repository;

    @Override
    public Bill AddBill (Bill bill){
        return bill_repository.save(bill);
    }

     @Override
    public Bill FindBillById( int id){
         Optional<Bill> bill = bill_repository.FindById(id);
         if (!bill.isPresent())
             throw new NotFoundException("Bill does not exist!.");
         return bill.get();
     }

     @Override
    public List<Bill> Bill_List(){
        return bill_repository.findAll();
     }

}
