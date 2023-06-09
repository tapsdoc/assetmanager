package com.example.assetmanager.api;

import com.example.assetmanager.service.employee.EmployeeRequest;
import com.example.assetmanager.service.employee.EmployeeResponse;
import com.example.assetmanager.service.employee.EmployeeService;
import com.example.assetmanager.service.stats.EmployeeStats;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeStats employeeStats;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/number-of-employees")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> numberOfEmployees() {
        return employeeStats.numberOfEmployees();
    }
}
