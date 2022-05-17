package com.example.demo.dao;

import com.example.demo.model.CompanyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<CompanyMaster,Integer> {

    List findAllByStatus(String active);
}
