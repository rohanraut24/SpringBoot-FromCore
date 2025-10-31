package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
//    Create
    void save(Student student);

//    Operations
    Student findById(int id);
    List<Student> sortedByFirstName();

//    Read
    List<Student> findAll();
    List<Student> findByFirstName(String theFirstName);


//    Update data with 2 ways
    void updateStudent();
    void updateStudentWithMergeFunction(Student theStudent);


//    Delete
    void deleteStudent(int id);
    void deleteAllData();
}
