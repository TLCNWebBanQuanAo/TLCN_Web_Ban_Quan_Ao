package hcmute.edu.vn.adminservice.model;
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
public class SaleOff_Product_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private SaleOff saleoff;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
