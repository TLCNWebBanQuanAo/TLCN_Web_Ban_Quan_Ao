package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.model.Bill_Detail;
import hcmute.edu.vn.userservice.repository.Bill_Detail_Repository;
import hcmute.edu.vn.userservice.service.BillDetail_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService_Impl implements BillDetail_Service {
    @Autowired
    private Bill_Detail_Repository bill_detail_repository;

    @Override

    public Bill_Detail AddBillProduct(Bill_Detail bill_detail){
        return bill_detail_repository.save(bill_detail);
    }
}
