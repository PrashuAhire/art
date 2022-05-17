package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.req.EmployeeLoginReqDto;
import com.example.demo.dto.req.EmployeeReqDto;
import com.example.demo.dto.req.EmployeeUpdatePasswordReqDto;
import com.example.demo.dto.res.EmployeeLoginResDto;
import com.example.demo.model.EmployeeMaster;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMasterServiceImpl implements EmployeeService {

    @Autowired
    private  EmployeeDao employeeDao;

    @Override
    public boolean create(EmployeeReqDto employeeReqDto) {
        EmployeeMaster employeeMaster=new EmployeeMaster();

        BeanUtils.copyProperties(employeeReqDto,employeeMaster);
        employeeMaster.setStatus("Active");
        try {
            employeeDao.save(employeeMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EmployeeReqDto employeeReqDto) {
        EmployeeMaster employeeMaster=new EmployeeMaster();

        BeanUtils.copyProperties(employeeReqDto,employeeMaster);
        try {
            employeeDao.save(employeeMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllEmployee() {
        return (List) employeeDao.findAll();
    }

    @Override
    public EmployeeReqDto getEmployeeById(Integer employeeId) {
        EmployeeReqDto employeeReqDto=new EmployeeReqDto();
        EmployeeMaster employeeMaster=new EmployeeMaster();
        try {
            Optional<EmployeeMaster> employeeMaster1=employeeDao.findById(employeeId);
            employeeMaster1.ifPresent(settingMaster -> BeanUtils.copyProperties(settingMaster, employeeReqDto));
            return employeeReqDto;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List getActiveEmployee() {
        List list=employeeDao.findAllByStatus("Active");
        return list;
    }

    @Override
    public EmployeeLoginResDto employeeLogin(EmployeeLoginReqDto employeeLoginReqDto) {

        //for Phno
        EmployeeMaster employeeMaster=employeeDao.findAllByEmployeeMobileNo(employeeLoginReqDto.getUserName());
        EmployeeLoginResDto employeeLoginResDto=new EmployeeLoginResDto();
        if (employeeMaster!=null)
        {
//            System.out.println("In mobile if");
//            if(employeeMaster==null){
//                employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
//                employeeLoginResDto.setMessage("User Name is Not Found");
//            }
//            else if(!employeeMaster.getEmployeeMobileNo().equals(employeePhoneNoLoginReqDto.getUserName())){
//                System.out.println("Mobile No is not equal");
//                employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
//                employeeLoginResDto.setMessage("User Name is Not Found");
//            }
//            else {
            if(employeeMaster.getEmployeePassword().equals(employeeLoginReqDto.getEmployeePassword())){
                if(employeeMaster.getStatus().equals("Active")){



                    employeeLoginResDto.setEmployeeId(employeeMaster.getEmployeeId());
                    employeeLoginResDto.setEmployeeDOB(employeeMaster.getEmployeeDOB());
                    employeeLoginResDto.setEmployeeFName(employeeMaster.getEmployeeFName());
                    employeeLoginResDto.setEmployeeMail(employeeMaster.getEmployeeMail());
                    employeeLoginResDto.setEmployeeMobileNo(employeeMaster.getEmployeeMobileNo());
                    employeeLoginResDto.setEmployeePhoto(employeeMaster.getEmployeePhoto());
                    employeeLoginResDto.setEmployeeAddress(employeeMaster.getEmployeeAddress());
                    employeeLoginResDto.setEmployeeRegisterDate(employeeMaster.getEmployeeRegisterDate());
                    employeeLoginResDto.setEmpType(employeeMaster.getEmpType());
                    employeeLoginResDto.setDesignationId(employeeMaster.getDesignationId());
                    employeeLoginResDto.setStatus(employeeMaster.getStatus());
                    employeeLoginResDto.setResponseCode(HttpStatus.OK.value());
                    employeeLoginResDto.setMessage("Login Success");
                    System.out.println("Login Success ");

                }else{
                    employeeLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    employeeLoginResDto.setMessage("Account Has Been Blocked");
                }
            }
            else {
                employeeLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                employeeLoginResDto.setMessage("Password Is Invalid");
            }
//            }
        }
        if(employeeMaster==null){
            employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            employeeLoginResDto.setMessage("User Name is Not Found");
        }
        else if(!employeeMaster.getEmployeeMobileNo().equals(employeeLoginReqDto.getUserName())){
            employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            employeeLoginResDto.setMessage("User Name is Not Found");
        }


        //for mail
        EmployeeMaster employeeMaster1=employeeDao.findAllByEmployeeMail(employeeLoginReqDto.getUserName());
        if (employeeMaster1!=null)
        {
            if(employeeMaster1.getEmployeePassword().equals(employeeLoginReqDto.getEmployeePassword())){
                if(employeeMaster1.getStatus().equals("Active")){

                    employeeLoginResDto.setEmployeeId(employeeMaster1.getEmployeeId());
                    employeeLoginResDto.setEmployeeDOB(employeeMaster1.getEmployeeDOB());
                    employeeLoginResDto.setEmployeeFName(employeeMaster1.getEmployeeFName());
                    employeeLoginResDto.setEmployeeMail(employeeMaster1.getEmployeeMail());
                    employeeLoginResDto.setEmployeeMobileNo(employeeMaster1.getEmployeeMobileNo());
                    employeeLoginResDto.setEmployeePhoto(employeeMaster1.getEmployeePhoto());
                    employeeLoginResDto.setEmployeeRegisterDate(employeeMaster1.getEmployeeRegisterDate());
                    employeeLoginResDto.setEmpType(employeeMaster1.getEmpType());
                    employeeLoginResDto.setDesignationId(employeeMaster1.getDesignationId());
                    employeeLoginResDto.setStatus(employeeMaster1.getStatus());
                    employeeLoginResDto.setResponseCode(HttpStatus.OK.value());
                    employeeLoginResDto.setMessage("Login Success");

                }else{
                    employeeLoginResDto.setResponseCode(HttpStatus.FORBIDDEN.value());
                    employeeLoginResDto.setMessage("Account Has Been Blocked");
                }
            }
            else {
                employeeLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                employeeLoginResDto.setMessage("Password Is Invalid");
            }
        }
        if(employeeMaster1==null){
            if (employeeMaster==null)
            {
                employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                employeeLoginResDto.setMessage("User Name is Not Found");
            }
        }
        else if(!employeeMaster1.getEmployeeMail().equals(employeeLoginReqDto.getUserName())){
            employeeLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            employeeLoginResDto.setMessage("User Name is Not Found");
        }
        return employeeLoginResDto;
    }

    @Override
    public Boolean employeeUpdatePassword(EmployeeUpdatePasswordReqDto employeeUpdatePasswordReqDto) {
        Integer updatePsw=employeeDao.employeeUpdatePassword(employeeUpdatePasswordReqDto.getEmployeeId(),employeeUpdatePasswordReqDto.getEmployeeNewPassword());
        return updatePsw!=0;
    }
}


