package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employees")
    public Employee AddEmp(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees") //Replace entire data
    /* Because of this method 'put' method, If you pass partial data then remaining data will be 'null'
     # Use of PUT
      If you just pass like below
      {
        "id":1,
        "lastName" :"cruise"
      }
      then it store as below :
       {
        "id": 1,
        "lastName": "cruise",
        "firstName": null,
        "email": null
       }
       Solution for this is use of : PATCH   ->send only required data that need to change
       In PatchMapping("/employees/{employeeId}") you need to provide @PathVariable
     */
    public Employee updateEmp(@RequestBody Employee employee){
        Employee e =employeeService.save(employee);
        return e;
    }

}
