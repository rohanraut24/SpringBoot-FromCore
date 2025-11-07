package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void DeleteById(int id);

    Employee save(Employee theEmployee);

    Employee findById(int id);
}
