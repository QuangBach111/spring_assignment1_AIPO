package com.example.spring_assignment1.service;

import com.example.spring_assignment1.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();
    void createOrUpdateDepartment(Department department);
    Department getDepartmentById(Long id);
}