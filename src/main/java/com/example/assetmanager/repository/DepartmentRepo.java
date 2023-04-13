package com.example.assetmanager.repository;

import com.example.assetmanager.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d")
    @Override
    List<Department> findAll();
}
