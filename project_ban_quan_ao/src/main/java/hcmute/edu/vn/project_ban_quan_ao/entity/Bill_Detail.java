package hcmute.edu.vn.project_ban_quan_ao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "bill_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill_Detail {

    @EmbeddedId
    private Bill_Product_Id id;

    private String size;
    private Double price;
    private int quantity;
    private Double total;
}
