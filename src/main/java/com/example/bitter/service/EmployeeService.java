package com.example.bitter.service;

import com.example.bitter.model.Department;
import com.example.bitter.model.Employee;
import com.example.bitter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public Map<Department, List<Employee>> allEmployeesGroupedByDepartment() {
        List<Employee> employees = repo.findAll();
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
