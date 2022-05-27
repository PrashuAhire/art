package com.example.demo.dao;

import com.example.demo.model.AttendanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceDetailsDao  extends JpaRepository<Integer, AttendanceDetails> {
}
