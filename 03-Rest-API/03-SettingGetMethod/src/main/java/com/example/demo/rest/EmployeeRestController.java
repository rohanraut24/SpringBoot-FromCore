package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);
        if(e==null){
            throw new RuntimeException("Employee not found of id -"+employeeId);
        }
        return employeeService.findById(employeeId);
    }
}
