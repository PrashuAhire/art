package com.example.demo.service.impl;

import com.example.demo.dao.EmpSkillDao;
import com.example.demo.dto.req.EmpSkillReqDto;
import com.example.demo.model.EmpSkillMaster;
import com.example.demo.service.EmpSkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpSkillServiceImpl implements EmpSkillService {



    @Autowired
    private EmpSkillDao empSkillDao;
    @Override
    public Boolean createEmpSkill(EmpSkillReqDto empSkillReqDto) {
        EmpSkillMaster empSkillMaster = new EmpSkillMaster();

        BeanUtils.copyProperties(empSkillReqDto,empSkillMaster);

try {
    empSkillDao.save(empSkillMaster);
    return  true;

}catch ( Exception e){
    e.printStackTrace();
    return  false;
}


    }

    @Override
    public Boolean updateEmpSkill(EmpSkillReqDto empSkillReqDto) {
        EmpSkillMaster empSkillMaster = new EmpSkillMaster();
        BeanUtils.copyProperties(empSkillReqDto, empSkillMaster);
        try {
            empSkillDao.save(empSkillMaster);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List getAllEmpSkillMaster() {
        return empSkillDao.findAll();
    }

    @Override
    public EmpSkillMaster getByEmpSkillId(Integer empSkillId) {
        EmpSkillMaster empSkillMaster = new EmpSkillMaster();
        try {
            Optional<EmpSkillMaster> empSkillMaster1=empSkillDao.findById(empSkillId);
            empSkillMaster1.ifPresent(settingMaster->BeanUtils.copyProperties(settingMaster,empSkillMaster));
            return empSkillMaster;
        }catch (Exception e){
            e.printStackTrace();
            return empSkillMaster;

        }

    }

}
