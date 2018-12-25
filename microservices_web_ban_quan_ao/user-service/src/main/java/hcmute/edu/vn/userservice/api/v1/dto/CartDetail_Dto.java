package hcmute.edu.vn.userservice.api.v1.dto;

import lombok.Data;

@Data
public class CartDetail_Dto {
    private String name;
    private Double price;
    private int quantity;
    private int size;
    private String describe;
    private String images;
    private int product_id;
}