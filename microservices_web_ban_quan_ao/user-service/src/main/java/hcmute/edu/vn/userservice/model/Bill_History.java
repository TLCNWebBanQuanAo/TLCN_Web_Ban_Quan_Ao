package hcmute.edu.vn.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill_History {
    private String name;

    @Size(max = 2000000)
    private String images;

    private String size;

    private Double price;

    private int quantity;

    private Double total;

}
