package hcmute.edu.vn.adminservice.api.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataReturnOne<T> {
    private String message;
    private String success="true";
    private T data;
}
