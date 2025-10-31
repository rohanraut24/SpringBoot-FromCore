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
//				queryForStudent(studentDAO);  //Get List of all student
//				findByFirstNameQuery(studentDAO);
				sortedByFirstName(studentDAO);
			};
		}

		private void sortedByFirstName(StudentDAO studentDAO) {
			List<Student> list = studentDAO.sortedByFirstName();
			for(Student s:list){
				System.out.println(s);
			}
		}

		private void findByFirstNameQuery(StudentDAO studentDAO) {
			List<Student> l =studentDAO.findByFirstName("rohan");
//			System.out.println(l);
			for(Student s:l){
				System.out.println(s);
			}
		}

		private void queryForStudent(StudentDAO studentDAO) {
			List<Student> list = studentDAO.findAll();
			for (Student s : list) {
				System.out.println(s);
			}

		}
	}