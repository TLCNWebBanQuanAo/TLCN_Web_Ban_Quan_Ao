package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Bill_Detail;
import hcmute.edu.vn.userservice.model.Bill_History;

import java.util.List;

public interface BillDetail_Service {
    Bill_Detail AddBillProduct(Bill_Detail bill_detail);
    List<Bill_History> detailBillById(Long bill_id);
}
