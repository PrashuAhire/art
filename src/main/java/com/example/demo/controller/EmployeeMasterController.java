package com.example.demo.controller;

import com.example.demo.dto.req.EmployeeLoginReqDto;
import com.example.demo.dto.req.EmployeeReqDto;
import com.example.demo.dto.req.EmployeeUpdatePasswordReqDto;
import com.example.demo.dto.res.EmpResDto;
import com.example.demo.dto.res.EmployeeLoginResDto;
import com.example.demo.model.EmployeeMaster;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employee_master")
@CrossOrigin("*")
public class EmployeeMasterController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    private ResponseEntity create(@RequestBody EmployeeReqDto employeeReqDto){
        boolean flag = employeeService.create(employeeReqDto);
        if(flag)
        {
            return new ResponseEntity(flag, HttpStatus.CREATED);}
        else
        {
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @PutMapping
    private ResponseEntity update(@RequestBody EmployeeReqDto employeeReqDto){

        boolean flag = employeeService.update(employeeReqDto);
        if(flag)
        {
            return new ResponseEntity(flag, HttpStatus.OK);}
        else
        {
            return new ResponseEntity(flag,HttpStatus.INTERNAL_SERVER_ERROR);}
    }


    @GetMapping
    private ResponseEntity getAllEmployee(){
        List list=employeeService.getAllEmployee();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{employeeId}")
    private ResponseEntity getEmployeeById(@PathVariable Integer employeeId){
        EmployeeReqDto employeeReqDto=employeeService.getEmployeeById(employeeId);

        if(employeeReqDto!=null){return new ResponseEntity(employeeReqDto, HttpStatus.OK);}
        else{return new ResponseEntity(employeeReqDto,HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @GetMapping(value = "/active")
    private ResponseEntity getActiveEmployee(){
        List list=employeeService.getActiveEmployee();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping(value = "/employeeLogin")
    public ResponseEntity employeeLogin(@RequestBody EmployeeLoginReqDto employeeLoginReqDto)
    {
        EmployeeLoginResDto employeeLoginResDto=employeeService.employeeLogin(employeeLoginReqDto);
        return new ResponseEntity(employeeLoginResDto,HttpStatus.OK);
    }

    @PostMapping(value = "/employeeUpdatePassword")
    public ResponseEntity employeeUpdatePassword(@RequestBody EmployeeUpdatePasswordReqDto employeeUpdatePasswordReqDto)
    {
        Boolean flag=employeeService.employeeUpdatePassword(employeeUpdatePasswordReqDto);
        return new ResponseEntity(employeeUpdatePasswordReqDto,HttpStatus.OK);
    }

    @GetMapping("/checkEmployeeMobNo/{employeeMobNo}")
    private ResponseEntity checkEmployeeMobNo(@PathVariable String employeeMobNo) {

        EmpResDto empResDto = employeeService.checkEmployeeMobNo(employeeMobNo);

        if (empResDto != null)
            return  new ResponseEntity(empResDto,HttpStatus.OK);
        else
            return  new ResponseEntity(empResDto,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
