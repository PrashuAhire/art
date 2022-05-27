package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class EmployeeReqDto {
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
    private Integer companyId;
}
