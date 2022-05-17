package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "designation_master")
public class DesignationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer desId;
    @Column(length = 50)
    private String desName;
    @Column (length = 100)
    private String desDescription;
    @Column(length = 10)
    private String status;



}
