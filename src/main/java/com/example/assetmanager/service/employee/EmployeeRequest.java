package com.example.assetmanager.service.employee;

import lombok.Data;

@Data
public class EmployeeRequest {

    private Long userId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private String designation;
    private String phoneNumber;
    private String address;
}
