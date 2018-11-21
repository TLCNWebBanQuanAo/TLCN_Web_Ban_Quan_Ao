package hcmute.edu.vn.userservice.api.v1.mapper;

import hcmute.edu.vn.userservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.userservice.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface Product_Mapper {
    Product_Dto ProductToProductDto(Product product);
}
