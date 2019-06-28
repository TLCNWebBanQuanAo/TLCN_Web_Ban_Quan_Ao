package hcmute.edu.vn.adminservice.service;

import hcmute.edu.vn.adminservice.model.Bill_Detail;
import hcmute.edu.vn.adminservice.model.Bill_History;

import java.util.List;

public interface BillDetail_Service {
    List<Bill_History> detailBillById(Long bill_id);
}
