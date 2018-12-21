package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.model.Type;
import hcmute.edu.vn.userservice.repository.Product_Repository;
import hcmute.edu.vn.userservice.repository.Type_Repository;
import hcmute.edu.vn.userservice.service.Product_Service;
import hcmute.edu.vn.userservice.service.Type_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService_Impl implements Type_Service {
    @Autowired
    private Type_Repository type_repository;

    @Override
    public List<Type> findAllType() {
        List<Type> types = type_repository.findAll();
        if(types.isEmpty())
            throw new NotFoundException("Not Fount Category");
        return types;
    }

}
