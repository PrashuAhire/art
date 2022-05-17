package com.example.demo.dao;

import com.example.demo.model.ProficiencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyDao extends JpaRepository<ProficiencyMaster,Integer> {
}
