package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//You can set endpoint also using @RepositoryRestResource(path="whatEverYouWant")

//From => http://localhost:8080/magic-api/employees
//To => http://localhost:8080/magic-api/members

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //Don't need to write anything 😁
}
