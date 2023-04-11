package com.example.assetmanager.service.statistics;

import com.example.assetmanager.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeStatisticsService {

    private final EmployeeRepo employeeRepo;
}
