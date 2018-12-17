package hcmute.edu.vn.adminservice.service;


import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.SaleOff;
import hcmute.edu.vn.adminservice.model.User;

import java.util.List;

public interface SaleOff_Service {
    SaleOff editSaleOff(SaleOff saleOff);
    SaleOff deleteSaleOff(int Id);
    SaleOff addSaleOff(SaleOff saleOff);
    SaleOff findSaleOffById(int Id);
    List<SaleOff> findAll();
}
