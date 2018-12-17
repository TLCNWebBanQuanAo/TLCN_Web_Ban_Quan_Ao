package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.dto.SaleOff_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.SaleOffMapper;
import hcmute.edu.vn.adminservice.api.v1.mapper.TypeMapper;
import hcmute.edu.vn.adminservice.model.SaleOff;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.repository.SaleOff_Repository;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.service.SaleOff_Service;
import hcmute.edu.vn.adminservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/sale/")
@CrossOrigin(origins = "http://localhost:4200")
public class SaleOff_Controller {
    @Autowired
    private SaleOff_Service saleOff_service;
    @Autowired
    private SaleOffMapper saleOffMapper;
    @PostMapping("/editsale")
    public SaleOff editSaleOff(@RequestBody SaleOff saleOff){
        return saleOff_service.editSaleOff(saleOff);
    }
    @PostMapping("/addsale")
    public SaleOff addSale(@RequestBody SaleOff saleOff){
        return saleOff_service.addSaleOff(saleOff);
    }
    @DeleteMapping("deletesale/{saleId}")
    public SaleOff_Dto deleteSale(@PathVariable int saleId){
        return saleOffMapper.saleOffToSaleOffDto(saleOff_service.deleteSaleOff(saleId));
    }
    @GetMapping("/sales/{saleID}")
    public SaleOff_Dto findSaleOffById(@PathVariable int saleID){
        return saleOffMapper.saleOffToSaleOffDto(saleOff_service.findSaleOffById(saleID));
    }

    @GetMapping("/sales")
    public List<SaleOff_Dto> findAll(){
        return saleOff_service.findAll().stream().map(saleOffMapper::saleOffToSaleOffDto).collect(Collectors.toList());
    }
}
