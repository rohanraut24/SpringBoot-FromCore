package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
		};
	}
	public void createStudent(StudentDAO studentDAO){
//		Create Student object
		Student tempStudent = new Student("Chintu","Raut","chintu@gmail.com");

//		Save the student object
		System.out.println("Saving student data...");
		studentDAO.save(tempStudent);

//		Display id of saved student
		System.out.println("Saved student id :"+tempStudent.getId());
	}

	public void createMultipleStudent(StudentDAO studentDAO){
//		Create Student object
		Student tempStudent1 = new Student("Prasad","Raut","prasad@gmail.com");
		Student tempStudent2= new Student("Shubham","Raut","shubham@gmail.com");
		Student tempStudent3= new Student("rohan","Raut","rohan@gmail.com");

//		Save the student object
		System.out.println("Saving student data...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


//		Display id of saved student
		System.out.println("Saved student id :"+tempStudent1.getId());
		System.out.println("Saved student id :"+tempStudent2.getId());
		System.out.println("Saved student id :"+tempStudent3.getId());

//		Suppose we delete any student , we want to set id with specific number then we can do this by
//		Delete from student_tracker.student where id=4;
//		Alter TABLE student_tracker.student AUTO_INCREMENT=4;
		//this thing is manual in MySQL
	}
}
