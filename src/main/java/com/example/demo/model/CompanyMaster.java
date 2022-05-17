package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter@Entity
@Table(name = "company_name")
public class CompanyMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer companyId;

    @Column(length = 500)
    private String companyName;

    @Column(length = 500)
    private String address;

    @Column(length = 10)
    private String mobileNo;

    @Column(length = 50)
    private String emailId;

    @Column(length = 15)
    private String status;

}
