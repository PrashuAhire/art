package com.example.demo.service;

import com.example.demo.dto.req.SkillReqDto;
import com.example.demo.model.SkillMaster;

import java.util.List;

public interface SkillService {

    Boolean createSkill(SkillReqDto skillReqDto);

    Boolean updateSkill(SkillReqDto skillReqDto);

    List getAllSkillMaster();

    SkillMaster getBySkillId(Integer skillId);
}
