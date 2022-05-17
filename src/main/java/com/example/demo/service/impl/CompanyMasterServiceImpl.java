package com.example.demo.service.impl;

import com.example.demo.dao.CompanyDao;
import com.example.demo.dto.req.CompanyReqDto;
import com.example.demo.model.CompanyMaster;
import com.example.demo.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyMasterServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;


    @Override
    public Boolean createCompany(CompanyReqDto companyReqDto) {
        CompanyMaster companyMaster=new CompanyMaster();

        companyMaster.setCompanyName(companyReqDto.getCompanyName());
        companyMaster.setAddress(companyReqDto.getAddress());
        companyMaster.setMobileNo(companyReqDto.getMobileNo());
        companyMaster.setEmailId(companyReqDto.getEmailId());
        companyMaster.setStatus(companyReqDto.getStatus());
        try {
            companyDao.save(companyMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean updateCompany(CompanyReqDto companyReqDto) {

        CompanyMaster companyMaster=new CompanyMaster();
        companyMaster.setCompanyId(companyReqDto.getCompanyId());
        companyMaster.setCompanyName(companyReqDto.getCompanyName());
        companyMaster.setAddress(companyReqDto.getAddress());
        companyMaster.setMobileNo(companyReqDto.getMobileNo());
        companyMaster.setEmailId(companyReqDto.getEmailId());
        companyMaster.setStatus(companyReqDto.getStatus());
        try {
            companyDao.save(companyMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List getAllCompanyMaster() {
        return companyDao.findAll();
    }

    @Override
    public List activeCompanyMaster() {
        return companyDao.findAllByStatus("Active");
    }

    @Override
    public CompanyMaster getByCompanyId(Integer companyId) {
        CompanyMaster companyMaster=new CompanyMaster();
        try {
            Optional<CompanyMaster> companyMaster1=companyDao.findById(companyId);
            companyMaster1.ifPresent(settingMaster -> BeanUtils.copyProperties( settingMaster, companyMaster));
            return companyMaster;
        }
        catch (Exception e) {
            e.printStackTrace();
            return companyMaster;
        }
    }
}
