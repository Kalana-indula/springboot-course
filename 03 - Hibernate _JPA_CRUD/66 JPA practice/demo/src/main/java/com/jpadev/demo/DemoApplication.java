package com.jpadev.demo;

import com.jpadev.demo.dao.StudentDAO;
import com.jpadev.demo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
//			readStudent(studentDAO);
			getAllStudents(studentDAO);
//			findByLastName(studentDAO);
//			updateStudent(studentDAO);
//			updateLastName(studentDAO);
//			deleteById(studentDAO);
		};
	}

	//Create student method
	private void createStudent(StudentDAO studentDAO){

		//create student object
		System.out.println("Creating new student object");
		Student newStudent=new Student("Emmy","Johns","emmy@email.com");

		//save the student object
		System.out.println("Save the student");
		studentDAO.save(newStudent);

		//display id of the saved student
		System.out.println("Saved student.Generated Id: "+newStudent.getId());
	}

	//read student
	private void readStudent(StudentDAO studentDAO){
		Student myStudent=studentDAO.findById(1);

		System.out.println("Found the student : "+myStudent);
	}

	//Retrieve all students
	private void getAllStudents(StudentDAO studentDAO){
		List<Student> studentList=studentDAO.findAll();

		for(Student student:studentList){
			System.out.println("Student Details : "+student);
		}
	}

	//Find by lastname
	private void findByLastName(StudentDAO studentDAO){

		List<Student> studentList=studentDAO.findByLastName("Simons");

		for(Student student:studentList){
			System.out.println("student : "+student);
		}
	}

	//update student
	private void updateStudent(StudentDAO studentDAO){

		int studentId=1;

		System.out.println("finding student with id "+studentId);

		Student theStudent=studentDAO.findById(studentId);

		//updating student name
		theStudent.setFirstName("Scooby");

		studentDAO.update(theStudent);

		System.out.println("Updated student : "+theStudent);
	}

	//update student lastName
	private void updateLastName(StudentDAO studentDAO){

		int numberOfStudents=studentDAO.updateStudent();

		System.out.println("Number of students : "+numberOfStudents);

		List<Student> studentList=studentDAO.findAll();

		for(Student student:studentList){
			System.out.println("Students : "+student);
		}
	}

	//delete a single student
	private void deleteById(StudentDAO studentDAO){

		int studentId=1;

		System.out.println("Deleting Student ID : "+studentId);

		studentDAO.delete(studentId);
	}

}
