package com.example.demo.controller;

import com.example.demo.dao.SkillDao;
import com.example.demo.dto.req.SkillReqDto;
import com.example.demo.model.SkillMaster;
import com.example.demo.service.SkillService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "skill_master")
@CrossOrigin("*")
public class SkillMasterController {

    @Autowired
    private SkillService skillService;
    @PostMapping()
    public ResponseEntity createSkill(SkillReqDto skillReqDto){
        Boolean flag =skillService.createSkill(skillReqDto);
        return  new ResponseEntity(flag, HttpStatus.OK);


    }
    @PutMapping ()
    public  ResponseEntity updateSkill(SkillReqDto skillReqDto){
        Boolean flag = skillService.updateSkill(skillReqDto);
        return  new ResponseEntity( flag ,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllSkillMaster")
    public ResponseEntity getAllSkillMaster(){
        List list = skillService.getAllSkillMaster();
        return  new ResponseEntity(list ,HttpStatus.OK);
    }
    @GetMapping(value = "/getBySkillId/{skillId}")
    public ResponseEntity getBySkillId(@PathVariable Integer skillId){
        SkillMaster skillMaster = skillService.getBySkillId(skillId);
        return  new ResponseEntity(skillMaster, HttpStatus.OK);
    }
}
