package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
     public List<Employee> findAll(){
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee",Employee.class);

        List<Employee> list = theQuery.getResultList();

        return list;
    }   

    //Here we don't add @Transactional because we manage this in service;
    @Override
    public void DeleteById(int id) {
        Employee e =entityManager.find(Employee.class ,id);
        entityManager.remove(e);
        System.out.println("Employee deleted :"+e);
    }

    //Here we don't add @Transactional because we manage this in service;
    @Override
    public Employee save(Employee theEmployee) {
        Employee emp =entityManager.merge(theEmployee); //If not exist(id==0) insert else update on that id
        return emp;
    }

    @Override
    public Employee findById(int id) {
        Employee e = entityManager.find(Employee.class,id);
        return e;
    }
}
