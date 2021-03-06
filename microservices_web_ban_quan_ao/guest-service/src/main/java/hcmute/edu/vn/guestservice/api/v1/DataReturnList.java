package hcmute.edu.vn.guestservice.api.v1.mapper;

import lombok.Data;

import java.util.List;

@Data
public class DataReturnList<T> {
    private String message;
    private String success = "true";
    private List<T> data;
}
