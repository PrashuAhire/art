package com.example.demo.service.impl;

import com.example.demo.dao.SkillDao;
import com.example.demo.dto.req.SkillReqDto;
import com.example.demo.model.SkillMaster;
import com.example.demo.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillMasterServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public Boolean createSkill(SkillReqDto skillReqDto) {
        SkillMaster skillMaster = new SkillMaster();
        skillMaster.setSkillName(skillReqDto.getSkillName());
        skillMaster.setSkillDescription(skillReqDto.getSkillDescription());
        try {
            skillDao.save(skillMaster);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean updateSkill(SkillReqDto skillReqDto) {
        SkillMaster skillMaster = new SkillMaster();
        skillMaster.setSkillName(skillReqDto.getSkillName());
        skillMaster.setSkillDescription(skillReqDto.getSkillDescription());
        try {
            skillDao.save(skillMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllSkillMaster() {
        return skillDao.findAll();
    }

    @Override
    public SkillMaster getBySkillId(Integer skillId) {
        SkillMaster skillMaster = new SkillMaster();
        try {
            Optional<SkillMaster> skillMaster1=skillDao.findById(skillId);
            skillMaster1.ifPresent(settingMaster-> BeanUtils.copyProperties(settingMaster, skillMaster));
            return  skillMaster;

        }catch (Exception e){
            e.printStackTrace();
            return  skillMaster;
        }

    }
}