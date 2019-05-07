package hcmute.edu.vn.userservice.api.v1.dto;

import lombok.Data;
@Data
public class Wishlist_Dto {
    private int productId;
    private int UserId;
    private Double wishPrice;
    private Double currentPrice;
    private String image;
    private String productName;
    private String briefInfo;
    private int quantity;

}


