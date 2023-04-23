package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e")
    @Override
    List<Employee> findAll();

    @Query("SELECT COUNT(e) FROM Employee e")
    Long numberOfEmployees();
}
