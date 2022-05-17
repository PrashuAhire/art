package com.example.demo.service;

import com.example.demo.dto.req.CompanyReqDto;
import com.example.demo.model.CompanyMaster;

import java.util.List;

public interface CompanyService {
    Boolean createCompany(CompanyReqDto companyReqDto);

    Boolean updateCompany(CompanyReqDto companyReqDto);

    List getAllCompanyMaster();

    List activeCompanyMaster();

    CompanyMaster getByCompanyId(Integer companyId);
}
