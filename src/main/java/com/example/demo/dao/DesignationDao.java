package com.example.demo.dao;

import com.example.demo.model.DesignationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationDao extends JpaRepository<DesignationMaster,Integer> {
    List findAllByStatus(String active);
}
