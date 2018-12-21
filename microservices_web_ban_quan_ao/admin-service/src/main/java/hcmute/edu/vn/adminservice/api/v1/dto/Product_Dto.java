package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;

@Data
public class Product_Dto {
    private String name;
    private Double price;
    private int status;
    private int quantity;
    private int size;
    private String discrible;
    private String images;
}
