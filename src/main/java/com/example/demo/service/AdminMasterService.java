package com.example.demo.service;

import com.example.demo.dto.req.AdminForgotPasswordReqDto;
import com.example.demo.dto.req.AdminLoginReqDto;
import com.example.demo.dto.req.AdminReqDto;
import com.example.demo.dto.req.AdminValidateOtpReqDto;
import com.example.demo.dto.res.AdminForgotPasswordResDto;
import com.example.demo.dto.res.AdminLoginResDto;
import com.example.demo.dto.res.AdminMasterResDto;
import com.example.demo.model.AdminMaster;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface AdminMasterService {
    boolean create(AdminReqDto adminReqDto);

    boolean update(AdminReqDto adminReqDto);

    AdminMaster getByAdminId(Integer adminId);

    List getAllAdminMaster();

    List activeAdminMaster();

    AdminLoginResDto adminLogin(AdminLoginReqDto adminLoginReqDto);

    AdminMasterResDto checkMobileNo(String mobileNo);

    AdminForgotPasswordResDto forgotPassword(AdminForgotPasswordReqDto adminForgotPasswordReqDto) throws NoSuchAlgorithmException, IOException, KeyManagementException;

    AdminForgotPasswordResDto validateOtp(AdminValidateOtpReqDto adminValidateOtpReqDto);


}
