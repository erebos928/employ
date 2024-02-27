package com.example.bitter.service;

import com.example.bitter.BitterApplication;
import com.example.bitter.repository.DepartmentRepository;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceIntegrationTest {
    @Autowired
    DepartmentService departmentService;
    @Test
    void listDepartments() {
      departmentService.listDepartments().stream().map(dep -> dep.getTitle()).forEach(System.out::println);
    }

    @Test
    void getDepartmentById() {
    }
}