package com.example.demo.service;

import com.example.demo.dto.req.EmployeeLoginReqDto;
import com.example.demo.dto.req.EmployeeReqDto;
import com.example.demo.dto.req.EmployeeUpdatePasswordReqDto;
import com.example.demo.dto.res.EmployeeLoginResDto;
import com.example.demo.model.EmployeeMaster;

import java.util.List;


public interface EmployeeService {
    

    boolean create(EmployeeReqDto employeeReqDto);

    boolean update(EmployeeReqDto employeeReqDto);

    List getAllEmployee();

    EmployeeReqDto getEmployeeById(Integer employeeId);

    List getActiveEmployee();

    EmployeeLoginResDto employeeLogin(EmployeeLoginReqDto employeeLoginReqDto);

    Boolean employeeUpdatePassword(EmployeeUpdatePasswordReqDto employeeUpdatePasswordReqDto);
}
