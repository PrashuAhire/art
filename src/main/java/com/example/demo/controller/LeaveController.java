package com.example.demo.controller;

import com.example.demo.dto.req.AcceptOrRejectOrderReqDto;
import com.example.demo.dto.req.LeaveDetailsReqDto;
import com.example.demo.model.LeaveDetails;
import com.example.demo.service.LeaveMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {

    @Autowired
    private LeaveMasterService leaveMasterService;


    @PostMapping
    private ResponseEntity create(@RequestBody LeaveDetailsReqDto leaveDetailsReqDto) {
        boolean flag = leaveMasterService.create(leaveDetailsReqDto);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);

        } else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping
    private ResponseEntity update(@RequestBody LeaveDetailsReqDto leaveDetailsReqDto) {
        boolean flag = leaveMasterService.update(leaveDetailsReqDto);
        if (flag) {
            return new ResponseEntity(flag, HttpStatus.OK);

        } else
            return new ResponseEntity(flag, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @GetMapping(value = "/getAllLeaveDetails")
    public ResponseEntity getAllLeaveDetails() {
        List list = leaveMasterService.getAllLeaveDetails();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/activeLeaveDetails")
    public ResponseEntity activeLeaveDetails() {
        List list = leaveMasterService.activeLeaveDetails();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getByLeaveDetailsId/{LeaveId}")
    public ResponseEntity getByLeaveDetailsId(@PathVariable Integer leaveDetailsId) {
        LeaveDetails leaveDetails = leaveMasterService.getByLeaveDetailsId(leaveDetailsId);
        return new ResponseEntity(leaveDetails, HttpStatus.OK);
    }

    //    @GetMapping(value = "/employee/{action}/{id}")
//    public ResponseEntity acceptOrRejectLeaves(@PathVariable ("action")String  action,@PathVariable("id")int id){
//                LeaveDetails leaveDetails =leaveMasterService.acceptOrRejectLeaves(id);
//
//                return  new ResponseEntity(leaveDetails ,HttpStatus.OK);
//    }
    @PutMapping(value = "/acceptorreject")
    private ResponseEntity acceptOrReject(@RequestBody AcceptOrRejectOrderReqDto acceptOrRejectOrderReqDto) {


        Boolean flag = leaveMasterService.acceptOrReject(acceptOrRejectOrderReqDto);


        return new ResponseEntity(flag, HttpStatus.CREATED);

    }
}

