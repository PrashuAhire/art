package com.example.demo.dao;

import com.example.demo.dto.req.SkillReqDto;
import com.example.demo.model.SkillMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends JpaRepository<SkillMaster, Integer> {

}
