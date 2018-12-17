package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.exception.NotFoundException;
import hcmute.edu.vn.adminservice.model.SaleOff;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.repository.SaleOff_Repository;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.service.SaleOff_Service;
import hcmute.edu.vn.adminservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleOffSerVice_Impl implements SaleOff_Service {
    @Autowired
    private SaleOff_Repository saleOff_repository;


    @Override
    public SaleOff editSaleOff(SaleOff saleOff) {
        if(saleOff == null)
            throw new NotFoundException("Sua khuyen mai khong thanh cong !!!");
        return saleOff_repository.save(saleOff);
    }

    @Override
    public SaleOff deleteSaleOff(int Id) {
        Optional<SaleOff> saleOff = saleOff_repository.findById(Id);
        saleOff_repository.delete(saleOff.get());
        return saleOff.get();
    }

    @Override
    public SaleOff addSaleOff(SaleOff saleOff) {
        if(saleOff == null)
            throw new NotFoundException("Them khuyen mai khong thanh cong !!!");
        return saleOff_repository.save(saleOff);
    }

    @Override
    public SaleOff findSaleOffById(int Id) {
        Optional<SaleOff> saleOff = saleOff_repository.findById(Id);
        if (!saleOff.isPresent())
            throw new NotFoundException("Not Found SaleOff");
        return saleOff.get();
    }

    @Override
    public List<SaleOff> findAll() {
        return saleOff_repository.findAll();
    }
}




