package com.example.demo.dto.res;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpResDto {

    private String message;

    private String flag;

    public void setFlag(boolean b) {
    }
}
