package hcmute.edu.vn.userservice.api.v1.dto;

import lombok.Data;

@Data
public class Product_Dto {
    private int id;
    private String name;
    private Double price;
    private int status;
    private int quantity;
    private String size;
    private String describe;
    private String images;
}
