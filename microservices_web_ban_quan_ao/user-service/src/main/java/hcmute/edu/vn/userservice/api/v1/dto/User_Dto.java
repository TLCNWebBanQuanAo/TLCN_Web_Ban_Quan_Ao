package hcmute.edu.vn.userservice.api.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User_Dto {
    private String name;
    private Date dateOfBirth;
    private int gender;
    private String accountName;
    private String password;
    private String avatar;
    private int role_id;
    private String address;
    private int phone;
    private String email;
    private int status;
}
