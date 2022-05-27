package com.example.demo.service;

import com.example.demo.dto.req.AcceptOrRejectOrderReqDto;
import com.example.demo.dto.req.LeaveDetailsReqDto;
import com.example.demo.model.LeaveDetails;

import java.util.List;

public interface LeaveMasterService {
    boolean create(LeaveDetailsReqDto leaveDetailsReqDto);

    boolean update(LeaveDetailsReqDto leaveDetailsReqDto);

    List getAllLeaveDetails();

    List activeLeaveDetails();

    LeaveDetails getByLeaveDetailsId(Integer leaveDetailsId);

   // LeaveDetails acceptOrRejectLeaves(int id);


    Boolean acceptOrReject(AcceptOrRejectOrderReqDto acceptOrRejectOrderReqDto);
}
