package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "employee_master")
public class EmployeeMaster {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer employeeId;

    @Column(length = 10)
    private String employeeUserName;

    @Column(length = 20)
    private String employeeName;

    @Column(length = 500,unique = true)
    private String employeeMail;

    @Column(length = 20,unique = true)
    private String employeeMobileNo;

    @Column(length = 25)
    private String employeePassword;

    @Column(length = 500)
    private String employeePhoto;

    @Column(length = 500)
    private String employeeAddress;

    @Column(length = 10)
    private String status;

    @Column (length =20)
    private String designationId;

    @Column(length = 20)
    private String empType;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date employeeDOB;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date employeeRegisterDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private  CompanyMaster companyMaster;
}
