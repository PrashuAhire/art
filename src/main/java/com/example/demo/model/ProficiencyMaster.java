package com.example.demo.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "proficiency_master")
public class ProficiencyMaster {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private  Integer profId;

    private String profName;

    private  String profDesignation;





}
