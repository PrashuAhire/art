package com.example.demo.controller;

import com.example.demo.dto.req.EmpSkillReqDto;
import com.example.demo.model.EmpSkillMaster;
import com.example.demo.service.EmpSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "empskill_master")
@CrossOrigin("*")
public class EmpSkillMasterController {


    @Autowired
    private EmpSkillService empSkillService;

    @PostMapping()
    public ResponseEntity createEmpSkill(EmpSkillReqDto empSkillReqDto){
        Boolean flag = empSkillService. createEmpSkill(empSkillReqDto);
        return new ResponseEntity(flag, HttpStatus.OK);
    }

    @PutMapping()
    public  ResponseEntity updateEmpSkill(EmpSkillReqDto empSkillReqDto){
        Boolean flag = empSkillService.updateEmpSkill(empSkillReqDto);
        return  new ResponseEntity(flag,HttpStatus.OK);

    }

    @GetMapping("/getAllEmpSkillMaster")
    public  ResponseEntity getAllEmpSkillMaster(){
        List list = empSkillService.getAllEmpSkillMaster();
        return  new ResponseEntity(list ,HttpStatus.OK);
    }

    @GetMapping(value = "/getByEmpSkillId/{empSkillId}")
    public  ResponseEntity getByEmpSkillId(@PathVariable Integer empSkillId){
        EmpSkillMaster empSkillMaster = empSkillService.getByEmpSkillId(empSkillId);
        return  new ResponseEntity( empSkillMaster,HttpStatus.OK);
    }


}
