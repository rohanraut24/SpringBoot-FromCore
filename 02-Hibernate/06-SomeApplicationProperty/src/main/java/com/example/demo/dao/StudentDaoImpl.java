package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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


//    Implement Save method
    @Override
    @Transactional   //Because we are updating the transaction in database
    public void save(Student theStudent){
        entityManager.persist(theStudent);  //persist is to save theStudent in database
    }

    //    @Transation //No need because we are not updating,saving data
    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Get List of all student
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
        return theQuery.getResultList();
    }
    @Override
    public List<Student> findByFirstName(String theFirstName){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE firstname=:data",Student.class);
        query.setParameter("data",theFirstName);
        return query.getResultList();
    }
    @Override
    public List<Student> sortedByFirstName(){
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY firstname desc",Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(){
        int updatedRowCount = entityManager.createQuery("UPDATE Student s set s.lastname='Shinde' where s.firstname='Rudra'")
                .executeUpdate();
        System.out.println("Student is updated.");
        System.out.println("Number of rows updated : "+updatedRowCount);
    }

    @Override
    @Transactional
    public void updateStudentWithMergeFunction(Student theStudent){
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional  //This is important ,If you are doing any kind of change in database
    public void deleteStudent(int id){
//        Method 1
//        entityManager.createQuery("DELETE FROM Student s WHERE s.id=:id")
//                .setParameter("id",id)
//                .executeUpdate();

//        Method 2
        Student s = entityManager.find(Student.class,id);
        entityManager.remove(s);
        System.out.println("Removed successfully with id :"+id);
    }

    @Override
    @Transactional
    public void deleteAllData() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("All data is removed");
    }

}
