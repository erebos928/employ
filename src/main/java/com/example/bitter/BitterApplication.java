package com.example.bitter;

import com.example.bitter.model.Department;
import com.example.bitter.model.Employee;
import com.example.bitter.repository.DepartmentRepository;
import com.example.bitter.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BitterApplication {
    @Autowired
    EmployeeRepository repo;
    @Autowired
    DepartmentRepository depRepo;
    public static void main(String[] args) {
        SpringApplication.run(BitterApplication.class, args);
    }

    //@Override
   /*
    @Transactional
    public void run(String... args) throws Exception {

        Department software = Department.builder().id(788).title("Software").build();
        Department hardware = Department.builder().id(344).title("Hardware").build();
        Department accounting = Department.builder().id(655).title("Accounting").build();
        depRepo.save(software);
        depRepo.flush();
        Employee employee1 = Employee.builder().id(1009).name("Marcus").build();
        employee1.setDepartment(software);
        repo.save(employee1);
        Employee employee2 = Employee.builder().id(2008).name("Tina").build();
        employee2.setDepartment(software);
        repo.save(employee2);
        Employee employee3 = Employee.builder().id(2765).name("Paulin").build();
        employee3.setDepartment(hardware);
        repo.save(employee3);
        Employee employee4 = Employee.builder().id(2719).name("Andrea").build();
        employee4.setDepartment(accounting);
        repo.save(employee4);
        repo.flush();
    }*/
}
