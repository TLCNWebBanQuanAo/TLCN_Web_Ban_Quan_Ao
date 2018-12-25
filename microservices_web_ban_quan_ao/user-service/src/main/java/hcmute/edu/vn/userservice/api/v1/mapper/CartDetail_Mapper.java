package hcmute.edu.vn.userservice.api.v1.mapper;

import hcmute.edu.vn.userservice.api.v1.dto.CartDetail_Dto;
import hcmute.edu.vn.userservice.model.Cart_Detail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartDetail_Mapper   {
    CartDetail_Mapper INSTANCE = Mappers.getMapper(CartDetail_Mapper.class);
    @Mappings({
            @Mapping(source = "id.product.images", target ="images"),
            @Mapping(source = "id.product.describe", target = "describe"),
            @Mapping(source = "id.product.name", target = "name"),
            @Mapping(source = "id.product.id", target = "product_id"),
            @Mapping(source = "id.product.price", target = "price")

    })
    CartDetail_Dto CartDetailToCartDetailDto(Cart_Detail cart_detail);
}