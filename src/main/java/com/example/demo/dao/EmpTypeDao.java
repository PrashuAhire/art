package com.example.demo.dao;

import com.example.demo.model.EmpTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpTypeDao extends JpaRepository<EmpTypeMaster,Integer> {
}



