package com.example.demo.service.impl;

import com.example.demo.dao.AttendanceDetailsDao;
import com.example.demo.dto.req.AttendanceDetailsReqDto;
import com.example.demo.model.AttendanceDetails;
import com.example.demo.service.AttendanceDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceDetailsServiceImpl  implements AttendanceDetailsService {

    @Autowired

    private AttendanceDetailsDao attendanceDetailsDao;


    @Override
    public boolean addUser(AttendanceDetailsReqDto attendanceDetailsReqDto) {

        AttendanceDetails attendanceDetails = new AttendanceDetails();
        BeanUtils.copyProperties(attendanceDetailsReqDto,attendanceDetails);
        try {
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }



    }
}
