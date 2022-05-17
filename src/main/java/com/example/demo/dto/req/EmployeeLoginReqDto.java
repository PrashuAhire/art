package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EmployeeLoginReqDto {
    private String userName;
    private String employeePassword;
}
