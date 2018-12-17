package hcmute.edu.vn.adminservice.service;


import hcmute.edu.vn.adminservice.model.Type;

import java.util.List;

public interface Type_Service {
    Type addType(Type type);
    Type editType(Type type);
    Type deleteType(int Id);
    Type findTypeById(int Id);
    List<Type> findAll();
}
