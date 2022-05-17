package com.example.demo.controller;

import com.example.demo.dto.req.ProficiencyReqDto;
import com.example.demo.model.ProficiencyMaster;
import com.example.demo.service.ProficiencyService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "proficiency_master")
@CrossOrigin("*")
public class ProficiencyMasterController {

    @Autowired
    private ProficiencyService proficiencyService;

    @PostMapping()
    public ResponseEntity createProficiency(@RequestBody ProficiencyReqDto proficiencyReqDto){
        Boolean flag = proficiencyService.createProficiency(proficiencyReqDto);
        return  new ResponseEntity(flag, HttpStatus.OK);

    }
    @PutMapping()
    public  ResponseEntity updateProficiency(@RequestBody ProficiencyReqDto proficiencyReqDto){
        Boolean flag = proficiencyService.updateProficiency(proficiencyReqDto);
        return  new ResponseEntity(flag,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllProficiencyMaster")
    public  ResponseEntity getAllProficiencyMaster(){
        List list = proficiencyService.getAllProficiencyMaster();
            return new ResponseEntity(list,HttpStatus.OK);
        }

        @GetMapping(value = "/getByProficiencyId/{proficiencyId}")

    public  ResponseEntity getByProficiencyId(@PathVariable Integer proficiencyId){
            ProficiencyMaster proficiencyMaster = proficiencyService.getByPProficiencyId(proficiencyId);
            return new ResponseEntity(proficiencyMaster,HttpStatus.OK);
        }


    }

