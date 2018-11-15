package hcmute.edu.vn.userservice.api.v1;

import lombok.Data;

@Data
public class DataReturnRecord<T> {
    private String message;
    private String success = "true";
    private T data;
}
