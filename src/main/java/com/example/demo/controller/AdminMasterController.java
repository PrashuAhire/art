package com.example.demo.controller;

import com.example.demo.dto.req.AdminForgotPasswordReqDto;
import com.example.demo.dto.req.AdminLoginReqDto;
import com.example.demo.dto.req.AdminReqDto;
import com.example.demo.dto.req.AdminValidateOtpReqDto;
import com.example.demo.dto.res.AdminForgotPasswordResDto;
import com.example.demo.dto.res.AdminLoginResDto;
import com.example.demo.dto.res.AdminMasterResDto;
import com.example.demo.model.AdminMaster;
import com.example.demo.service.AdminMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin_master")
public class AdminMasterController {

    @Autowired
    private AdminMasterService adminMasterService;

    @PostMapping
    public ResponseEntity create(@RequestBody AdminReqDto adminReqDto){
        boolean flag=adminMasterService.create(adminReqDto);
        if(flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody AdminReqDto adminReqDto){
        boolean flag=adminMasterService.update(adminReqDto);
        if(flag) {
            return new ResponseEntity(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "getByAdminId/{adminId}")
    public ResponseEntity getByAdminId(@PathVariable Integer adminId) {
        AdminMaster adminMaster = adminMasterService.getByAdminId(adminId);
        return new ResponseEntity(adminMaster, HttpStatus.OK);
    }
    @GetMapping(value = "getAllAdminMaster")
    public ResponseEntity getAllAdminMaster() {
        List list = adminMasterService.getAllAdminMaster();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/activeAdminMaster")
    public ResponseEntity activeAdminMaster() {
        List list = adminMasterService.activeAdminMaster();

        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping(value = "/adminLogin")
    public ResponseEntity adminLogin(@RequestBody AdminLoginReqDto adminLoginReqDto)
    {
        AdminLoginResDto adminLoginResDto=adminMasterService.adminLogin(adminLoginReqDto);
        return new ResponseEntity(adminLoginResDto,HttpStatus.OK);
    }
    @GetMapping("/checkMobileNo/{mobileNo}")
    public ResponseEntity checkMobileNo(@PathVariable String mobileNo) {

        AdminMasterResDto adminMasterResDto = adminMasterService.checkMobileNo(mobileNo);

        if (adminMasterResDto != null)
            return new ResponseEntity(adminMasterResDto, HttpStatus.OK);
        else
            return new ResponseEntity(adminMasterResDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping(value = "/forgotPassword")
    public ResponseEntity forgotPassword(@RequestBody AdminForgotPasswordReqDto adminForgotPasswordReqDto) throws NoSuchAlgorithmException, IOException, KeyManagementException {
        AdminForgotPasswordResDto adminForgotPasswordResDto=adminMasterService.forgotPassword(adminForgotPasswordReqDto);
        return new ResponseEntity(adminForgotPasswordResDto,HttpStatus.OK);
    }
    @PostMapping(value = "/validateotp")
    public ResponseEntity validateOtp(@RequestBody AdminValidateOtpReqDto adminValidateOtpReqDto)
    {
        AdminForgotPasswordResDto adminForgotPasswordResDto = adminMasterService.validateOtp(adminValidateOtpReqDto);
        return new ResponseEntity(adminForgotPasswordResDto,HttpStatus.OK);
    }

}
