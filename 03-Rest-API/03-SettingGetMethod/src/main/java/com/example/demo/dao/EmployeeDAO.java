package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    void DeleteById(int id);

    Employee save(Employee theEmployee);

    Employee findById(int id);
}
