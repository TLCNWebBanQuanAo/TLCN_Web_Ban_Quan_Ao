package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class User_Dto {
    private int id;
    private String name;
    private Date dateOfBirth;
    private int gender;
    private String accountName;
    private String password;
    private String avatar;
    private String address;
    private String phone;
    private String email;
    private int status;
    private int role_id;
}
