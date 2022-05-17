package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "empskill_master")
@Entity
public class EmpSkillMaster {

       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private  Integer empSkillId;
       private  String skillId;
       private  String proficiencyId;


}
