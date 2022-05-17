package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "skill_master")
public class SkillMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(length = 100)
    private Integer skillId;

    @Column(length = 50)
    private String skillName;

    @Column(length = 20)
    private String  skillDescription;
}
