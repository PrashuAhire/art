package com.example.demo.service;

import com.example.demo.dto.req.ProficiencyReqDto;
import com.example.demo.model.ProficiencyMaster;

import java.util.List;

public interface ProficiencyService {
    Boolean createProficiency(ProficiencyReqDto proficiencyReqDto);

    Boolean updateProficiency(ProficiencyReqDto proficiencyReqDto);

    List getAllProficiencyMaster();

    ProficiencyMaster getByPProficiencyId(Integer proficiencyId);
}
