package com.example.demo.service.impl;

import com.example.demo.dao.ProficiencyDao;
import com.example.demo.dto.req.ProficiencyReqDto;
import com.example.demo.model.ProficiencyMaster;
import com.example.demo.service.ProficiencyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProficiencyServiceImpl implements ProficiencyService {

    @Autowired
    private ProficiencyDao proficiencyDao;


    @Override
    public Boolean createProficiency(ProficiencyReqDto proficiencyReqDto) {
         ProficiencyMaster proficiencyMaster = new ProficiencyMaster();

         proficiencyMaster.setProfName(proficiencyReqDto.getProfName());
         proficiencyMaster.setProfDesignation(proficiencyReqDto.getProfDesignation());
         try {
             proficiencyDao.save(proficiencyMaster);
             return  true;
         }catch (Exception e){
             return false;
         }


    }

    @Override
    public Boolean updateProficiency(ProficiencyReqDto proficiencyReqDto) {
        ProficiencyMaster proficiencyMaster = new ProficiencyMaster();

        proficiencyMaster.setProfName(proficiencyReqDto.getProfName());
        proficiencyMaster.setProfDesignation(proficiencyReqDto.getProfDesignation());
        try {
            proficiencyDao.save(proficiencyMaster);
            return  true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List getAllProficiencyMaster() {
        return proficiencyDao.findAll();
    }

    @Override
    public ProficiencyMaster getByPProficiencyId(Integer proficiencyId) {
        ProficiencyMaster proficiencyMaster = new ProficiencyMaster();
        try {
            Optional<ProficiencyMaster>proficiencyMaster1=proficiencyDao.findById(proficiencyId);
            proficiencyMaster1.ifPresent(settingMaster-> BeanUtils.copyProperties(settingMaster,proficiencyId));
            return  proficiencyMaster;
        }catch (Exception e){
            e.printStackTrace();
            return  proficiencyMaster;
        }
    }
}
