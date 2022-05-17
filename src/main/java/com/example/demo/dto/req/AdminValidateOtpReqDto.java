package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AdminValidateOtpReqDto {

    private Integer adminId;

    private Integer otp;
}
