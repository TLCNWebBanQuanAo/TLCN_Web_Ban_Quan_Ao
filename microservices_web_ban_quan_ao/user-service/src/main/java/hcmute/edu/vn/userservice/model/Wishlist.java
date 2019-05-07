package hcmute.edu.vn.userservice.model;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "wishlist")
@Data

public class Wishlist {
    @EmbeddedId
    Wishlist_Id wishlist_id;
    private Double dealPrice;
}
