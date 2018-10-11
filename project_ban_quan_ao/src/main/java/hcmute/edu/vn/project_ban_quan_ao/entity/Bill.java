package hcmute.edu.vn.project_ban_quan_ao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "bills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double total;
    private int status;
    private String address;
    private int phone;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @OneToMany(mappedBy = "id.bill")
    private Set<Bill_Detail> bill_details;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
