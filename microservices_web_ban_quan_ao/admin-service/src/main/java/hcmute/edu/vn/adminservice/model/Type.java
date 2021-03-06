package hcmute.edu.vn.adminservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @OneToMany(mappedBy = "type")
    private Set<Product> products;
}
