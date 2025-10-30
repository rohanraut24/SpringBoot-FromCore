package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//Sub annotation of @Component, which provide some extra features like,
//Translate JDBC exceptions ,Support component scanning

@Repository
public class StudentDaoImpl implements StudentDAO{
//    define field for EntityManager

    private EntityManager entityManager;

//    Inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

//    Implement Save method
    @Override
    @Transactional   //Because we are updating the transaction in database
    public void save(Student theStudent){
        entityManager.persist(theStudent);  //persist is to save theStudent in database
    }

    @Override
//    @Transation //No need because we are not updating,saving data
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }
}
