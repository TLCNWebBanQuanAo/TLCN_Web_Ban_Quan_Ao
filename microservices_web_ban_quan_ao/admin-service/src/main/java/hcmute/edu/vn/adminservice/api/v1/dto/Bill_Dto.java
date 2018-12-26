package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Bill_Dto {
    private int id;
    private Double total;
    private int status;
    private String address;
    private String phone;
    private String userCreate;
    private Date dateCreate;
}
