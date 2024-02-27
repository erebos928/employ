package com.example.bitter.controller;

import com.example.bitter.model.Department;
import com.example.bitter.model.Employee;
import com.example.bitter.service.DepartmentService;
import com.example.bitter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/add")
    String getAddPage(Model model){
        List<Department> deps = departmentService.listDepartments();
        model.addAttribute("departments",deps);
        return "addpage";
    }
    @PostMapping("/add")
    String postAddEmployee(@RequestParam(name = "departmentId") long departmentId,
                           @RequestParam(name="name") String employeeName,Model model){
        Optional<Department> optDepartment = departmentService.getDepartmentById(departmentId);
        if (optDepartment.isPresent()) {
            Employee employee = Employee.builder().name(employeeName).department(optDepartment.get()).build();
            employeeService.addEmployee(employee);
            return "redirect:/employee/grouping";
        }
        else {
            model.addAttribute("errorMessage",String.format("No department with id (%s) found.",departmentId));
            return "error";
        }
    }
    @GetMapping("/grouping")
    String groupedList(Model model){
        Map<Department,List<Employee>> map = employeeService.allEmployeesGroupedByDepartment();
        model.addAttribute("resultMap",map);
        return "totalEmployees";
    }
}
