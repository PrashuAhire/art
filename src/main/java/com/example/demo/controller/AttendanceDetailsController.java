package com.example.demo.controller;

import com.example.demo.dto.req.AttendanceDetailsReqDto;
import com.example.demo.service.AttendanceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceDetailsController {

    @Autowired
    private AttendanceDetailsService attendanceDetailsService;



    @PostMapping
    public ResponseEntity addUser(@RequestBody AttendanceDetailsReqDto attendanceDetailsReqDto){
         boolean flag  = attendanceDetailsService.addUser(attendanceDetailsReqDto);
         if (flag)
         {
             return  new ResponseEntity(flag, HttpStatus.OK);}
         else
             return  new ResponseEntity(flag ,HttpStatus.INTERNAL_SERVER_ERROR);
         }

    }


//    public ResponseEntity<?> addUser(@RequestBody AttendanceDetail attendancedetail) {
//        HttpHeaders headers = new HttpHeaders();
//
//        try {
//            //System.out.println("en da ipdi "+employeeid+employeeservice.findByempid(employeeid));
//            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(attendanceservice.addUser(attendancedetail));
//        }catch (Exception e) {
//            headers.add("Message", "false");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body("Failed to add the user");
//        }