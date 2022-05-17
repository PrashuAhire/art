package com.example.demo.controller;

import com.example.demo.dto.req.EmpSkillReqDto;
import com.example.demo.service.EmpTypeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "empType_master")
@CrossOrigin("*")
public class EmpTypeMasterController {

          @Autowired
             private EmpTypeService empTypeService;
           @PostMapping()
          public ResponseEntity createEmpTypeMaster(@RequestBody EmpSkillReqDto empSkillReqDto){
              Boolean flag = empTypeService.createEmpTypeMaster(empSkillReqDto);
              return new ResponseEntity(flag, HttpStatus.OK);
          }


}
