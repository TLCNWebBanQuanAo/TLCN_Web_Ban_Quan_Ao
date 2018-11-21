package hcmute.edu.vn.userservice.api.v1.mapper;

import hcmute.edu.vn.userservice.api.v1.dto.Bill_Dto;
import hcmute.edu.vn.userservice.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Bill_Mapper {
    Bill_Mapper INSTANCE = Mappers.getMapper(Bill_Mapper.class);
    Bill_Dto BillToBillDto (Bill bill);
}
