package com.example.assetmanager.service.employee;

import com.example.assetmanager.domain.Employee;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmployeeResponse {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private String phoneNumber;
    private String address;
    private String profileImage;

    public static EmployeeResponse of(@NonNull Employee employee) {
        EmployeeResponse response = new EmployeeResponse();

        response.setId(employee.getId());
        response.setUsername(employee.getUsers().getUsername());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setDepartment(employee.getDepartment().getName());
        response.setDesignation(employee.getDesignation());
        response.setPhoneNumber(employee.getPhoneNumber());
        response.setAddress(employee.getAddress());
        response.setProfileImage(employee.getProfileImage());
        return response;
    }

    public static List<EmployeeResponse> of(List<Employee> employees) {
        return employees.stream().map(EmployeeResponse::of).collect(Collectors.toList());
    }
}
