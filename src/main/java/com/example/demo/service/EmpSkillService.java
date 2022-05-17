package com.example.demo.service;

import com.example.demo.dto.req.EmpSkillReqDto;
import com.example.demo.model.EmpSkillMaster;

import java.util.List;

public interface EmpSkillService {
    Boolean createEmpSkill(EmpSkillReqDto empSkillReqDto);

    Boolean updateEmpSkill(EmpSkillReqDto empSkillReqDto);

    List getAllEmpSkillMaster();

    EmpSkillMaster getByEmpSkillId(Integer empSkillId);
}