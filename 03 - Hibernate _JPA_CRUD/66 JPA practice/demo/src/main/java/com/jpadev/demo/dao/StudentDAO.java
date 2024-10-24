package com.jpadev.demo.dao;

import com.jpadev.demo.entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    //add a method to find an entity
    Student findById(Integer id);

    //Retrieving all students
    List<Student> findAll();

    //Find by last name
    List<Student> findByLastName(String theLastName);

    //Update student
    void update(Student theStudent);

    //Multiple update
    Integer updateStudent();

    //delete an existing student
    void delete(Integer id);


}
