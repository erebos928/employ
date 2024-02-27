package com.example.bitter.service;

import com.example.bitter.model.Department;
import com.example.bitter.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
Tests DepartmentService object without real repository injected in.
 */
@ExtendWith(MockitoExtension.class)
class DepartmentServiceUnitTest {

    @Mock
    DepartmentRepository departmentRepository;
    @InjectMocks
    DepartmentService departmentService;
    @Test
    void listDepartments() {
        Mockito.when(departmentRepository.findAll()).thenReturn(List.of(Department.builder().id(123).title("xxx").build()));
        List<Department> deps = departmentService.listDepartments();
        assertNotNull(deps);
        deps.stream().forEach((dep) -> System.out.println(String.format("id= %d, title= %s",dep.getId(),dep.getTitle())));
    }

    @Test
    void getDepartmentById() {
    }
}