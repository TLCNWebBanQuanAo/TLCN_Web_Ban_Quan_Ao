package hcmute.edu.vn.guestservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Wishlist_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
