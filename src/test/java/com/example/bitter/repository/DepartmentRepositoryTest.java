package com.example.bitter.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;
    @Test
    void testFindAll(){
        departmentRepository.findAll().stream().map((d)->d.getTitle()).forEach(System.out::println);
    }
}