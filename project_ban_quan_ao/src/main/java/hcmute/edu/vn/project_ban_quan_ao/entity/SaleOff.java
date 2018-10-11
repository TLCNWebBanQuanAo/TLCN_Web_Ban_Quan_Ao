package hcmute.edu.vn.project_ban_quan_ao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "saleoffs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dateStart;
    private Date dateEnd;
    private String userCreate;
    private Date dateCreate;
    private String userUpdate;
    private Date dateUpdate;

    @OneToMany(mappedBy = "id.saleoff")
    private Set<SaleOff_Detail> saleoff_details;
}
