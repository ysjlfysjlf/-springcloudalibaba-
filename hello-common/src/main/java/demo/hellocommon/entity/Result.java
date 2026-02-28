package demo.hellocommon.entity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private int code;
    private String description;

    public Result(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
