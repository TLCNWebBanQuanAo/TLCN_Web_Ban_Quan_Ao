package hcmute.edu.vn.guestservice.api.v1.dto;

import lombok.Data;

@Data
public class Product_Dto {
    private String name;

    private String discrible;

    private String images;

    private int quantity;

    private String status;

    private float price;
}
