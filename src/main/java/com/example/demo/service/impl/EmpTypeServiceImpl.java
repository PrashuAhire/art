package com.example.demo.service.impl;

import com.example.demo.dao.EmpTypeDao;
import com.example.demo.dto.req.EmpSkillReqDto;
import com.example.demo.model.EmpTypeMaster;
import com.example.demo.service.EmpTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpTypeServiceImpl implements EmpTypeService {

    @Autowired
    private EmpTypeDao empTypeDao;


    @Override
    public Boolean createEmpTypeMaster(EmpSkillReqDto empSkillReqDto) {
        EmpTypeMaster empTypeMaster = new EmpTypeMaster();

        BeanUtils.copyProperties(empSkillReqDto,empTypeMaster);

        try {
            empTypeDao.save(empTypeMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
