package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "leave_details")
public class LeaveDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer leaveId;

    private String employeeName;

    private String employeeId;

    private Date fromDate;

    private  Date toDate;

    private String leaveType;

    private  String reason;

    private  int duration;

    private  boolean acceptRejectFlag;

    private boolean status;


}
