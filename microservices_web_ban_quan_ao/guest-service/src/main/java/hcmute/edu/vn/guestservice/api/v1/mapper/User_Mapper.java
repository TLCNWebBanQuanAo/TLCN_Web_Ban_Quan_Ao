package hcmute.edu.vn.guestservice.api.v1.mapper;

import hcmute.edu.vn.guestservice.api.v1.dto.User_Dto;
import hcmute.edu.vn.guestservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface User_Mapper {
    User_Mapper INSTANCE = Mappers.getMapper(User_Mapper.class);

    User_Dto userToUserDto(User user);
}
