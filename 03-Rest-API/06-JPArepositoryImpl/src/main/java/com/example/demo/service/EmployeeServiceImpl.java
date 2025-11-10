package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
//    @Transactional
    public void DeleteById(int id) {
        employeeRepository.deleteById(id); //deleteById is predefine method in JPARepository
    }

    @Override
//    @Transactional //No need ,because JPARepository manage all this
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee emp =null;
        if(result.isPresent()){
            emp =result.get();
        }
        else{
            throw new RuntimeException("Employee not found with id -"+id);
        }
        return emp;
    }

}
