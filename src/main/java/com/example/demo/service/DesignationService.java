package com.example.demo.service;

import com.example.demo.dto.req.DesignationReqDto;
import com.example.demo.model.DesignationMaster;

import java.util.List;

public interface DesignationService {
    Boolean createdesignation(DesignationReqDto designationReqDto);

    Boolean updatedesignation(DesignationReqDto designationReqDto);

    List getAllDesignationMaster();

    DesignationMaster getByDesignationId(Integer designationId);

    List activeDesignationMaster();
}
