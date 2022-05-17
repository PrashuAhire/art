package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EmployeeUpdatePasswordReqDto {
    private Integer employeeId;
    private String employeeNewPassword;
}
