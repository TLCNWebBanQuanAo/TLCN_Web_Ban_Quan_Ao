package hcmute.edu.vn.project_ban_quan_ao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "saleoff_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOff_Detail {
    @EmbeddedId
    private SaleOff_Product_Id id;
    private int discount;
}
