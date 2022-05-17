package com.example.demo.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter@AllArgsConstructor
public class LeaveResDto {
    private  Integer leaveId;

    private String  employeeName;

    private String employeeId;

    private Date fromDate;

    private  Date toDate;

    private String leaveType;

    private  String reason;

    private int  duration;

    private  boolean acceptRejectFlag;

    private String status;

    private  Integer empId;
}
