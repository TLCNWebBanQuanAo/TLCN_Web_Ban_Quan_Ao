package hcmute.edu.vn.guestservice.api.v1.dto;

import lombok.Data;

@Data
public class User_Dto {
    private String accountName;
    private String password;
    private int role_id;
    private String address;
}
