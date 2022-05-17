package com.example.demo.controller;


import com.example.demo.dto.req.CompanyReqDto;
import com.example.demo.model.CompanyMaster;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "company_master")
public class CompanyMasterController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity createCompany(@RequestBody CompanyReqDto companyReqDto)
    {
        Boolean flag =companyService.createCompany(companyReqDto);
        return new ResponseEntity(flag, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity updateCompany(@RequestBody CompanyReqDto companyReqDto)
    {
        Boolean flag =companyService.updateCompany(companyReqDto);
        return new ResponseEntity(flag, HttpStatus.OK);
    }


    @GetMapping(value = "/getAllCompanyMaster")
    public ResponseEntity getAllCompanyMaster(){
        List list=companyService.getAllCompanyMaster();
        return new ResponseEntity(list,HttpStatus.OK);
    }


    @GetMapping("/activeCompanyMaster")
    public ResponseEntity activeCompanyMaster() {
        List list = companyService.activeCompanyMaster();

        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping(value = "getByCompanyId/{companyId}")
    public ResponseEntity getByCompanyId(@PathVariable Integer companyId) {
        CompanyMaster companyMaster = companyService.getByCompanyId(companyId);
        return new ResponseEntity(companyMaster, HttpStatus.OK);
    }
}
