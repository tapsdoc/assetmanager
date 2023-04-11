package com.example.assetmanager.service.department;

import com.example.assetmanager.domain.Department;
import com.example.assetmanager.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;


    @Override
    public Department addDepartment(DepartmentRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepo.findById(id).orElseThrow(() -> new IllegalStateException("Department not found"));
    }

    @Override
    public Department editDepartment(Long id, DepartmentRequest request) {

        var department = getById(id);
        if (request.getName() != null) {
            department.setName(request.getName());
        }
        return departmentRepo.save(department);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalStateException("Department not found");
        }
        departmentRepo.deleteById(id);
    }
}
