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
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner -> {
	//			createStudent(studentDAO);
				readStudent(studentDAO);
			};
		}

		public void createStudent(StudentDAO studentDAO) {
			Student tempStudent = new Student("Chintu", "Raut", "chintu@gmail.com");
			studentDAO.save(tempStudent);
			System.out.println("Saved student id :" + tempStudent.getId());
		}

		public void readStudent(StudentDAO studentDAO) {
//		 	You can Direct read data if you know id
			Student tempStudent = studentDAO.findById(6);
			System.out.println("Found Student: "+tempStudent);
	//
	//		First we create data then save and then get student id from it
			// First we create data then save and then get student id from it
//			Student temp = new Student("Ram", "Raut", "ram@gmail.com");
//			studentDAO.save(temp);


//			Student tempStudent = studentDAO.findById(temp.getId());

//			System.out.println(tempStudent);
		}
	}

