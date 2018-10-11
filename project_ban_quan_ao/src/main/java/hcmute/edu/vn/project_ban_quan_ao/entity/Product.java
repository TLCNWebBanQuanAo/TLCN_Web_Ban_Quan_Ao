package hcmute.edu.vn.project_ban_quan_ao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Double price;
    private int status;
    private int quanlity;
    private int size;
    private String discrible;
    private String images;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @OneToMany(mappedBy = "id.product")
    private Set<Bill_Detail> bill_details;

    @OneToMany(mappedBy = "id.product")
    private Set<SaleOff_Detail> saleoff_details;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;
}
