package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "attendance")
public class AttendanceDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
