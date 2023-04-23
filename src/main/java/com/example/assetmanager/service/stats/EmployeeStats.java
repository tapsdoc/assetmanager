package com.example.assetmanager.service.stats;

import com.example.assetmanager.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeStats {

    private final EmployeeRepo employeeRepo;

    public Map<String, Long> numberOfEmployees() {
        Long count = employeeRepo.numberOfEmployees();
        Map<String, Long> result = new HashMap<>();
        result.put("Employees", count);
        return result;
    }
}
