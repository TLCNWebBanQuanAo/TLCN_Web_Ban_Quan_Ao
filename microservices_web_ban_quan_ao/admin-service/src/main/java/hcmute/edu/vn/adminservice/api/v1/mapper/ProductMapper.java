package hcmute.edu.vn.adminservice.api.v1.mapper;

import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product_Dto productToProductDto(Product product);
}
