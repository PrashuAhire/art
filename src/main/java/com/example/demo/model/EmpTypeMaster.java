package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "emptype_master")
public class EmpTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer empTypeId;

    private String empTypeName;

    private String  empTypeDescription;
}
