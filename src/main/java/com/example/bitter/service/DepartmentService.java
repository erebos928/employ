package com.example.bitter.service;

import com.example.bitter.model.Department;
import com.example.bitter.model.Employee;
import com.example.bitter.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public List<Department> listDepartments(){
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }

}
