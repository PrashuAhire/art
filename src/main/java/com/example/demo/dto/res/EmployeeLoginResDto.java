package com.example.demo.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class EmployeeLoginResDto {
    private Integer employeeId;
    private String employeeFName;
    private String employeeMail;
    private String employeeMobileNo;
    private String employeePassword;
    private String employeePhoto;
    private String employeeAddress;
    private String status;
    private String empType;
    private String designationId;
    private Date employeeDOB;
    private Date employeeRegisterDate;
    //extra
    private Integer responseCode;
    private String message;
}
