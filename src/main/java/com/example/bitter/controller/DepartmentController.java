package com.example.bitter.controller;

import com.example.bitter.model.Department;
import com.example.bitter.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @GetMapping("/add")
    public String addDepartment(){
        return "ridirect:/display";
    }
    @GetMapping("/display")
    public String displayDepartments(Model model){
        List<Department> list = service.listDepartments();
        model.addAttribute("departments",list);
        return "listdepartments";
    }

}
