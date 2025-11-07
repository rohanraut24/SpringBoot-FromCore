package com.example.demo.rest;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService,ObjectMapper objMap){
        this.employeeService =employeeService;
        this.objectMapper =objMap;
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

    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee employee){
        Employee e =employeeService.save(employee);
        return e;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchMethod(@PathVariable int employeeId, @RequestBody Map<String,Object> payLoad){
        Employee EmpInDatabase =employeeService.findById(employeeId);
        if(EmpInDatabase==null){
            throw new RuntimeException("Employee not found with id - "+employeeId);
        }
        if(payLoad.containsKey("id")){//ContainsKey search for String not for int
            System.out.println("Don't pass id");
            throw new RuntimeException("Employee id not allowed to pass -"+employeeId);
        }
        Employee updatedEmp = applyMethod(payLoad,EmpInDatabase);

        Employee emp = employeeService.save(updatedEmp);
        return emp;
    }

    public Employee applyMethod(Map<String,Object> payLoad,Employee EmpInDatabase){

        //Convert EmpInDatabase to JSON object Node
        ObjectNode employeeNode = objectMapper.convertValue(EmpInDatabase,ObjectNode.class);

        //Convert payLoad to JSON object Node
        ObjectNode patchNode = objectMapper.convertValue(payLoad,ObjectNode.class);

        //Merge patch updates to Employee Node
        employeeNode.setAll(patchNode);

        //Again convert JSON to Employee class
        return objectMapper.convertValue(employeeNode,Employee.class);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String DeleteEmployee(@PathVariable int employeeId){
        Employee e  = employeeService.findById(employeeId);
        if(e==null){
            throw new RuntimeException("Employee not found for id :"+employeeId);
        }
        employeeService.DeleteById(employeeId);
        return "Employee deleted successfully";
    }

}
