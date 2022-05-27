package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AttendanceDetailsReqDto {


    private int attendanceId;

    private String employeeId;

    private  String month;

    private Date date;

    private  String  DepartmentId;

    private Boolean availabe;

    private  String checkIn;

    private String checkOut;

    private  String  shift;

}
