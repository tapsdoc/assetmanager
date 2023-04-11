package com.example.assetmanager.service.employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAll();
    EmployeeResponse getEmployee(Long id);
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse editEmployee(Long id, EmployeeRequest request);
    void delete(Long id);
}
