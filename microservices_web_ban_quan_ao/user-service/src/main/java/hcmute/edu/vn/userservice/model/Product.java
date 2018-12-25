package hcmute.edu.vn.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    private int quantity;
    private String size;
    private String describe;
    @Size(max = 2000000)
    private String images;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @OneToMany(mappedBy = "id.product")
    private Set<Bill_Detail> bill_details;

    @OneToMany(mappedBy = "id.product")
    private Set<SaleOff_Detail> saleoff_details;

    @OneToMany(mappedBy = "id.product")
    private Set<Cart_Detail> cart_details;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;
}
