package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    Student findById(int id);
    void updateStudent();
    void updateStudentWithMergeFunction(Student theStudent);
}
