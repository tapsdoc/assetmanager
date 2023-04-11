package com.example.assetmanager.service.department;

import com.example.assetmanager.domain.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(DepartmentRequest request);
    List<Department> getAll();
    Department getById(Long id);
    Department editDepartment(Long id, DepartmentRequest request);
    void delete(Long id);
}
