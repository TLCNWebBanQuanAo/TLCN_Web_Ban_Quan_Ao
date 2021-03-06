package hcmute.edu.vn.guestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date dateOfBirth;
    private int gender;
    private String accountName;
    private String password;
    @Size(max = 2000000)
    private String avatar;
    private String address;
    private String phone;
    private String email;
    private int status;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Bill> bills;

    @OneToOne( fetch = FetchType.LAZY)
    private Cart cart;
}
