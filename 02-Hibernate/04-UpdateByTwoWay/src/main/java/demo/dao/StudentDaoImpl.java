package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.spec.PSource;
import java.util.List;


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

    @Override
    public Student findById(int id) {
        Student myStudent = entityManager.find(Student.class,id);
        return myStudent;
    }

    @Override
    @Transactional
    public void updateStudent(){
        int updatedRowCount = entityManager.createQuery("UPDATE Student s set s.firstname='Rudra' where s.firstname='Chintu'")
                .executeUpdate();
        System.out.println("Student is updated.");
        System.out.println("Number of rows updated : "+updatedRowCount);
    }

    @Override
    @Transactional
     public void updateStudentWithMergeFunction(Student theStudent){
        entityManager.merge(theStudent);
     }
}
