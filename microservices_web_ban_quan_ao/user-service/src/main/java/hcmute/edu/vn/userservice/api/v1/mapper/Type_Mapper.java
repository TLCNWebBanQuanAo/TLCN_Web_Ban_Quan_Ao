package hcmute.edu.vn.userservice.api.v1.mapper;


import hcmute.edu.vn.userservice.api.v1.dto.Type_Dto;
import hcmute.edu.vn.userservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.userservice.model.Type;
import hcmute.edu.vn.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Type_Mapper {
    Type_Mapper INSTANCE = Mappers.getMapper(Type_Mapper.class);
Type_Dto TypeToTypeDto(Type type);
}
