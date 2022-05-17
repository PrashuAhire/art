package com.example.demo.dto.req;

import com.example.demo.model.LeaveDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LeaveDetailsReqDto extends LeaveDetails {

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

}

