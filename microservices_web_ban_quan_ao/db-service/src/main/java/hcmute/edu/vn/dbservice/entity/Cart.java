package hcmute.edu.vn.dbservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double total;

    @OneToMany(mappedBy = "id.cart")
    private Set<Cart_Detail> cart_details;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
