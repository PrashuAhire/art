package com.example.demo.dao;

import com.example.demo.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeMaster,Integer> {


    List findAllByStatus(String active);

    EmployeeMaster findAllByEmployeeMobileNo(String userName);

    EmployeeMaster findAllByEmployeeMail(String userName);


    @Query("update EmployeeMaster as em set em.employeePassword=:employeeNewPassword where em.employeeId=:employeeId")
    Integer employeeUpdatePassword(@Param("employeeId") Integer employeeId, @Param("employeeNewPassword") String employeeNewPassword);

    EmployeeMaster findByEmployeeMobNo(String employeeMobNo);

}
