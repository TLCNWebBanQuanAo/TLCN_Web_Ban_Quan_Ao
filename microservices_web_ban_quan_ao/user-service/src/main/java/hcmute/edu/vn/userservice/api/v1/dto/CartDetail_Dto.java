package hcmute.edu.vn.userservice.api.v1.dto;

import lombok.Data;

@Data
public class CartDetail_Dto {
    private String name;
    private Double price;
    private int quanlity;
    private int size;
    private String discrible;
    private String images;
}