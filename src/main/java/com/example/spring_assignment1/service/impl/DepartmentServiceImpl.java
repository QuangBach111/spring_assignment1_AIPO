package com.example.spring_assignment1.service.impl;

import com.example.spring_assignment1.model.Department;
import com.example.spring_assignment1.repository.DepartmentRepository;
import com.example.spring_assignment1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

    @Override
    public void createOrUpdateDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return this.departmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

}