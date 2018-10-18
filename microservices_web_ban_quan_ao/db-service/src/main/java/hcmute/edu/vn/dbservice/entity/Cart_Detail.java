package hcmute.edu.vn.dbservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "cart_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart_Detail {
    @EmbeddedId
    private Cart_Product_Id id;
    private String size;
    private Double price;
    private int quantity;
}
