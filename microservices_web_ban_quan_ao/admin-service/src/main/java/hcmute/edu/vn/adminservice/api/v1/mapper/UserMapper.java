package hcmute.edu.vn.adminservice.api.v1.mapper;

import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User_Dto userToUserDto(User user);
}
