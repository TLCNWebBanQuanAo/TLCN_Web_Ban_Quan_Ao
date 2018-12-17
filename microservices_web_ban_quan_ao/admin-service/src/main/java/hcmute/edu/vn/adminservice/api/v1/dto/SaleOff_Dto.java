package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SaleOff_Dto {
    private int id;
    private Date dateStart;
    private Date dateEnd;

}
