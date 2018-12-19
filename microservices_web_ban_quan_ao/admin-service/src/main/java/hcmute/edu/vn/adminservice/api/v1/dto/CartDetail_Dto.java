package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;

@Data
public class CartDetail_Dto {
    private String name;
    private Double price;
    private int quantity;
    private int size;
    private String discrible;
    private String images;
}