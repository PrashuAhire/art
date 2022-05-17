package com.example.demo.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CompanyReqDto {

    private Integer companyId;

    private String companyName;

    private String address;

    private String mobileNo;

    private String emailId;

    private String status;
}
