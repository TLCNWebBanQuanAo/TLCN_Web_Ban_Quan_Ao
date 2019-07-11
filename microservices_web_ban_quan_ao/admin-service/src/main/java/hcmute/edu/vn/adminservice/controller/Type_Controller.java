package hcmute.edu.vn.adminservice.controller;


import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.TypeMapper;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.service.Type_Service;
import hcmute.edu.vn.adminservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin/type")
@CrossOrigin(origins = "http://localhost:4200")
public class Type_Controller {
    @Autowired
    private Type_Service type_service;
    @Autowired
    private TypeMapper typeMapper;
    @PostMapping("/edittype")
    public Type editType(@RequestBody Type type){
        return type_service.editType(type);
    }
    @PostMapping("/addtype")
    public Type addType(@RequestBody Type type){
        return type_service.addType(type);
    }
    @DeleteMapping("deletetype/{typeId}")
    public Type_Dto deletType(@PathVariable int typeId){
        return typeMapper.typeToTypeDto(type_service.deleteType(typeId));
    }
    @GetMapping("/types/{typeID}")
    public Type_Dto findTypeById(@PathVariable int typeID){
        return typeMapper.typeToTypeDto(type_service.findTypeById(typeID));
    }

    @GetMapping("/types")
    public List<Type_Dto> findAll(){
        return type_service.findAll().stream().map(typeMapper::typeToTypeDto).collect(Collectors.toList());
    }
}
