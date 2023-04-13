package com.example.assetmanager.api;

import com.example.assetmanager.domain.Department;
import com.example.assetmanager.service.department.DepartmentRequest;
import com.example.assetmanager.service.department.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("api/v1/department/")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Department addDepartment(@RequestBody DepartmentRequest request) {
        return departmentService.addDepartment(request);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getById(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department editDepartment(@PathVariable Long id, @RequestBody DepartmentRequest request) {
        return departmentService.editDepartment(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
