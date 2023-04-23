package com.example.assetmanager.service.employee;

import com.example.assetmanager.domain.Employee;
import com.example.assetmanager.domain.Users;
import com.example.assetmanager.repository.DepartmentRepo;
import com.example.assetmanager.repository.EmployeeRepo;
import com.example.assetmanager.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;
    private final UserRepo userRepo;

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = new ArrayList<>(employeeRepo.findAll());
        return EmployeeResponse.of(employees);
    }

    @Override
    public EmployeeResponse getEmployee(Long id) {
        var employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalStateException("Employee not found"));
        return EmployeeResponse.of(employee);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Employee employee = new Employee();
        var user = userRepo.findById(request.getUserId());

        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        Users existingUser = user.get();
        if (existingUser.getEmployee() != null) {
            throw new RuntimeException("User already has an associated employee!");
        }
        employee.setUsers(existingUser);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        var department = departmentRepo.findById(request.getDepartmentId());
        if (department.isEmpty()) {
            throw new IllegalStateException("Department not found");
        }
        employee.setDepartment(department.get());
        employee.setDesignation(request.getDesignation());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setAddress(request.getAddress());

        var savedEmployee = employeeRepo.save(employee);

        return EmployeeResponse.of(savedEmployee);
    }

    @Override
    public EmployeeResponse editEmployee(Long id, EmployeeRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalStateException("No employee found");
        }
        employeeRepo.deleteById(id);
    }
}
