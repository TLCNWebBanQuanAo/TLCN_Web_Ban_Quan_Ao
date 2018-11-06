package hcmute.edu.vn.guestservice.api.v1.mapper;

import hcmute.edu.vn.guestservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.guestservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Product_Mapper {
    Product_Mapper INTANCE = Mappers.getMapper(Product_Mapper.class);
    Product_Dto productToProductDto(Product product);
}
