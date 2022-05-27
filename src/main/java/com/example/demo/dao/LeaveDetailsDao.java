package com.example.demo.dao;

import com.example.demo.dto.res.LeaveResDto;
import com.example.demo.model.LeaveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveDetailsDao extends JpaRepository<LeaveDetails,Integer> {


    List findAllByStatus(String active);
}