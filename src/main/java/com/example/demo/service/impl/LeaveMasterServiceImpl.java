package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.LeaveDetailsDao;
import com.example.demo.dto.req.AcceptOrRejectOrderReqDto;
import com.example.demo.dto.req.LeaveDetailsReqDto;
import com.example.demo.model.CompanyMaster;
import com.example.demo.model.EmployeeMaster;
import com.example.demo.model.LeaveDetails;
import com.example.demo.service.LeaveMasterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveMasterServiceImpl implements LeaveMasterService {

    @Autowired
    private LeaveDetailsDao leaveDetailsDao;

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public boolean create(LeaveDetailsReqDto leaveDetailsReqDto) {
        LeaveDetails leaveDetails = new LeaveDetails();
        leaveDetails.setLeaveId(leaveDetailsReqDto.getLeaveId());
        leaveDetails.setDuration(leaveDetailsReqDto.getDuration());
        leaveDetails.setEmployeeId(leaveDetailsReqDto.getEmployeeId());
        leaveDetails.setEmployeeName(leaveDetailsReqDto.getEmployeeName());
        leaveDetails.setLeaveType(leaveDetailsReqDto.getLeaveType());
        leaveDetails.setReason(leaveDetailsReqDto.getReason());
        leaveDetails.setToDate(leaveDetailsReqDto.getToDate());
        leaveDetails.setFromDate(leaveDetailsReqDto.getFromDate());
        leaveDetails.setAcceptRejectFlag(leaveDetailsReqDto.isAcceptRejectFlag());
        try {
            leaveDetailsDao.save(leaveDetails);
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LeaveDetailsReqDto leaveDetailsReqDto) {
        LeaveDetails leaveDetails = new LeaveDetails();
        leaveDetails.setLeaveId(leaveDetailsReqDto.getLeaveId());
        leaveDetails.setDuration(leaveDetailsReqDto.getDuration());
        leaveDetails.setEmployeeId(leaveDetailsReqDto.getEmployeeId());
        leaveDetails.setEmployeeName(leaveDetailsReqDto.getEmployeeName());
        leaveDetails.setLeaveType(leaveDetailsReqDto.getLeaveType());
        leaveDetails.setReason(leaveDetailsReqDto.getReason());
        leaveDetails.setToDate(leaveDetailsReqDto.getToDate());
        leaveDetails.setFromDate(leaveDetailsReqDto.getFromDate());
        leaveDetails.setAcceptRejectFlag(leaveDetailsReqDto.isAcceptRejectFlag());
        {
            try {
                leaveDetailsDao.save(leaveDetails);
                return true;

            }catch (Exception e){
                e.printStackTrace();
            }
            return  false;
        }
    }

    @Override
    public List getAllLeaveDetails() {
        return leaveDetailsDao.findAll();

    }

    @Override
    public List activeLeaveDetails() {
        return leaveDetailsDao.findAllByStatus("Active");


    }

    @Override
    public LeaveDetails getByLeaveDetailsId(Integer leaveDetailsId) {
      LeaveDetails leaveDetails = new LeaveDetails();
      try {
          Optional<LeaveDetails> leaveDetails1 = leaveDetailsDao.findById(leaveDetailsId);
          leaveDetails1.ifPresent(settingMaster -> BeanUtils.copyProperties(settingMaster,leaveDetails));
      }catch (Exception e){
          e.printStackTrace();
          return leaveDetails;
      }
        return null;
    }



    @Override
    public Boolean acceptOrReject(AcceptOrRejectOrderReqDto acceptOrRejectOrderReqDto) {
      boolean leaveflag = false;
      if (acceptOrRejectOrderReqDto.getActive().equalsIgnoreCase("Accepted") ){
            String employeeMobileNo = acceptOrRejectOrderReqDto.getEmployeeMobileNo();
          EmployeeMaster employeeMaster = employeeDao.
      }

        return null;
    }


}
