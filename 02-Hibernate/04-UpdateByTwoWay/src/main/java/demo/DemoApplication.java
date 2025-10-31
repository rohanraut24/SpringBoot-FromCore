	package com.example.demo;

	import com.example.demo.dao.StudentDAO;
	import com.example.demo.entity.Student;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.context.annotation.Bean;

	import java.util.List;

	@SpringBootApplication
	public class DemoApplication {

		public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
		}

		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner -> {
//				updateStudent(studentDAO);  //With createQuery()
				updateStudentWithMergeFunction(studentDAO);

			};
		}

		private void updateStudentWithMergeFunction(StudentDAO studentDAO){
			int studentId = 1;
			Student theStudent = studentDAO.findById(1);

			theStudent.setFirstname("Ravan");
			studentDAO.updateStudentWithMergeFunction(theStudent);

			System.out.println("Updated student :"+theStudent);
		}

	}