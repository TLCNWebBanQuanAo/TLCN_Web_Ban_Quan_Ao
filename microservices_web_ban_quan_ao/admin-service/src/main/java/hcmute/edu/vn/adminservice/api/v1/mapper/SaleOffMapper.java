package hcmute.edu.vn.adminservice.api.v1.mapper;

import hcmute.edu.vn.adminservice.api.v1.dto.SaleOff_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.adminservice.model.SaleOff;
import hcmute.edu.vn.adminservice.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface SaleOffMapper {
    SaleOffMapper INSTANCE = Mappers.getMapper(SaleOffMapper.class);


    SaleOff_Dto saleOffToSaleOffDto(SaleOff saleOff);
}
