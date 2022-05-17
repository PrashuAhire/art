package com.example.demo.service.impl;

import com.example.demo.dao.DesignationDao;
import com.example.demo.dto.req.DesignationReqDto;
import com.example.demo.model.DesignationMaster;
import com.example.demo.service.DesignationService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationServiceImpl implements DesignationService {


    @Autowired
    private DesignationDao designationDao;
    @Override
    public Boolean createdesignation(DesignationReqDto designationReqDto) {
        DesignationMaster designationMaster = new DesignationMaster();

        designationMaster.setDesName(designationReqDto.getDesName());
        designationMaster.setDesDescription(designationReqDto.getDesDescription());
        try {
            designationDao.save(designationMaster);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updatedesignation(DesignationReqDto designationReqDto) {
        DesignationMaster designationMaster = new DesignationMaster();

        designationMaster.setDesName(designationReqDto.getDesName());
        designationMaster.setDesDescription(designationReqDto.getDesDescription());
        try {
            designationDao.save(designationMaster);
            return  true;

        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public List getAllDesignationMaster() {
          return  designationDao.findAll();
    }

    @Override
    public DesignationMaster getByDesignationId(Integer designationId) {
        DesignationMaster designationMaster = new DesignationMaster();
        try {
            Optional<DesignationMaster> designationMaster1 =designationDao.findById(designationId);
            designationMaster1.ifPresent(settingMaster -> BeanUtils.copyProperties(settingMaster,designationMaster));
            return designationMaster;

        }catch (Exception e){
            e.printStackTrace();
            return  designationMaster;
        }

    }

    @Override
    public List activeDesignationMaster() {

        return designationDao.findAllByStatus("Active");
    }
}
