package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.exception.NotFoundException;
import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;
import hcmute.edu.vn.adminservice.repository.Type_Repository;
import hcmute.edu.vn.adminservice.repository.User_Repository;
import hcmute.edu.vn.adminservice.service.Type_Service;
import hcmute.edu.vn.adminservice.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeSerVice_Impl implements Type_Service {
    @Autowired
    private Type_Repository type_repository;


    @Override
    public Type addType(Type type) {
        if(type == null)
            throw new NotFoundException("Them loai khong thanh cong !!!");
        return type_repository.save(type);
    }

    @Override
    public Type editType(Type type) {
        if(type == null)
            throw new NotFoundException("Sua loai khong thanh cong !!!");
        return type_repository.save(type);
    }

    @Override
    public Type deleteType(int Id) {
        Optional<Type> type = type_repository.findById(Id);
        type_repository.delete(type.get());
        return type.get();
    }

    @Override
    public Type findTypeById(int Id) {
        Optional<Type> type = type_repository.findById(Id);
        if (!type.isPresent())
            throw new NotFoundException("Not Found User");
        return type.get();
    }

    @Override
    public List<Type> findAll() {
        return type_repository.findAll();
    }
}




