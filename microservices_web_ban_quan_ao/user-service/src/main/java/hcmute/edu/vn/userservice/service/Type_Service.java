package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.model.Type;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface Type_Service {
    List<Type> findAllType();
}
