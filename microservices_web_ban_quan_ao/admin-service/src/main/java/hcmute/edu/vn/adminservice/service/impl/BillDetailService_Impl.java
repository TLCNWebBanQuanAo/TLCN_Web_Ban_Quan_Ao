package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.model.Bill_Detail;
import hcmute.edu.vn.adminservice.model.Bill_History;
import hcmute.edu.vn.adminservice.repository.Bill_Detail_Repository;
import hcmute.edu.vn.adminservice.service.BillDetail_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDetailService_Impl implements BillDetail_Service {
    @Autowired
    private Bill_Detail_Repository bill_detail_repository;

    @Override
    public List<Bill_History> detailBillById(Long bill_id) {
        List<Object[]> temps = bill_detail_repository.detailBillById(bill_id);
        List<Bill_History> bill_historyList = new ArrayList<>();
        for (int i = 0; i < temps.size(); i++) {
            Bill_History temp = new Bill_History();
            temp.setName(String.valueOf(temps.get(i)[0]));
            temp.setImages(String.valueOf(temps.get(i)[1]));
            temp.setPrice(Double.valueOf(temps.get(i)[2].toString()));
            temp.setQuantity(Integer.valueOf(temps.get(i)[3].toString()));
            temp.setSize(String.valueOf(temps.get(i)[4]));
            temp.setTotal(Double.valueOf(temps.get(i)[5].toString()));
            bill_historyList.add(temp);
        }
        return bill_historyList;
    }

}
