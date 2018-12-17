package hcmute.edu.vn.userservice.api.v1.mapper;


import hcmute.edu.vn.userservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface User_Mapper {
    User_Mapper INSTANCE = Mappers.getMapper(User_Mapper.class);
@Mappings({@Mapping(source = "role.id", target = "role_id")})
    User_Dto UserToUserDto(User user);
}
