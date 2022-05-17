package com.example.demo.controller;

import com.example.demo.dto.req.DesignationReqDto;
import com.example.demo.model.DesignationMaster;
import com.example.demo.service.DesignationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "designation_master")
public class DesignationMasterController {

    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity createdesignation (DesignationReqDto designationReqDto){
        Boolean flag =designationService.createdesignation(designationReqDto);
        return  new ResponseEntity(flag, HttpStatus.OK);


    }
    @PutMapping
    public ResponseEntity updatedesignation (DesignationReqDto designationReqDto){
        Boolean flag = designationService.updatedesignation(designationReqDto);
        return  new ResponseEntity(flag, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllDesignationMaster")
    public ResponseEntity getAllDesignationMaster(){
        List list = designationService.getAllDesignationMaster();
        return  new ResponseEntity(list,HttpStatus.OK);

    }
    @GetMapping (value = "/ActiveDesignationMaster")
    public ResponseEntity activeDesignationMaster(){
        List list = designationService.activeDesignationMaster();
        return new ResponseEntity(list,HttpStatus.OK);

    }

    @GetMapping(value = "/getByDesignationId/{designationId}")
    public ResponseEntity getByDesignationId(@PathVariable Integer designationId)
    {
        DesignationMaster designationMaster = designationService.getByDesignationId(designationId);
        if (designationMaster !=null)
         return new ResponseEntity(designationMaster ,HttpStatus.OK);
       else
           return new ResponseEntity(designationMaster ,HttpStatus.OK);

    }
}
