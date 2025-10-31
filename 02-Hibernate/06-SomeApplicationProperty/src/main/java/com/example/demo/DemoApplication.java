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
//				#Create
				createStudent(studentDAO);
//				createMultipleStudent(studentDAO);

				//Read
//				queryForStudent(studentDAO);  //Get List of all student
//				sortedByFirstName(studentDAO);
//				findByFirstNameQuery(studentDAO);

//				Update
//				updateStudent(studentDAO);  //With createQuery()
//				updateStudentWithMergeFunction(studentDAO);

//				Delete
//				deleteById(studentDAO);
//				deleteAllData(studentDAO);
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
		}

		private void deleteAllData(StudentDAO studentDAO) {
			studentDAO.deleteAllData();
		}

		private void deleteById(StudentDAO studentDAO) {
			studentDAO.deleteStudent(6);
		}

		private void updateStudent(StudentDAO studentDAO) {
			studentDAO.updateStudent();  // Update by write condition in query
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

		private void updateStudentWithMergeFunction(StudentDAO studentDAO){
			int studentId = 1;
			Student theStudent = studentDAO.findById(1);

			theStudent.setFirstname("Ravan");
			studentDAO.updateStudentWithMergeFunction(theStudent);

			System.out.println("Updated student :"+theStudent);
		}

	}