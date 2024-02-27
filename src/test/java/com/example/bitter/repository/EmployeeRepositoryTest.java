package com.example.bitter.repository;

import com.example.bitter.model.Department;
import com.example.bitter.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest

class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TestEntityManager entityManager;


    @Test
    void InitialTest(){

        populate();
        List<Employee> list = employeeRepository.findAll();
        Map<Department,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        map.entrySet().forEach(this::display);
    }

    void display(Map.Entry<Department,List<Employee>> entry){
        System.out.println("DEPARTMENT: " + entry.getKey().getTitle());
        entry.getValue().stream().map(employee -> "Employee name: " + employee.getName()).forEach(System.out::println);
    }

    void populate(){
        Department software = Department.builder().id(788).title("Software").build();
        Department hardware = Department.builder().id(344).title("Hardware").build();
        Department accounting = Department.builder().id(655).title("Accounting").build();
        entityManager.persist(software);
        entityManager.persist(hardware);
        entityManager.persist(accounting);
        entityManager.flush();
        entityManager.getEntityManager().getTransaction().commit();
        entityManager.getEntityManager().getTransaction().begin();
        Employee employee1 = Employee.builder().id(1009).name("Marcus").build();
        employee1.setDepartment(software);
        entityManager.merge(employee1);
        Employee employee2 = Employee.builder().id(2008).name("Tina").build();
        employee2.setDepartment(software);
        entityManager.merge(employee2);
        Employee employee3 = Employee.builder().id(2765).name("Paulin").build();
        employee3.setDepartment(hardware);
        entityManager.merge(employee3);
        Employee employee4 = Employee.builder().id(2719).name("Andrea").build();
        employee4.setDepartment(accounting);
        entityManager.merge(employee4);
        entityManager.flush();
        entityManager.getEntityManager().getTransaction().commit();
    }
}