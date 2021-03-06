package hcmute.edu.vn.guestservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Bill_Product_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
