package hcmute.edu.vn.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;

    private String name;

    private String email;

    private String address;

    private String phone;

    private Date dateCreate;

    private int bill_id;
}
