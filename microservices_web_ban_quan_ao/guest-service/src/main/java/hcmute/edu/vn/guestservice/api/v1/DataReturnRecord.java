package hcmute.edu.vn.guestservice.api.v1.mapper;

import lombok.Data;

@Data
public class DataReturnRecord <T> {
    private String message;
    private String success = "true";
    private T data;
}
