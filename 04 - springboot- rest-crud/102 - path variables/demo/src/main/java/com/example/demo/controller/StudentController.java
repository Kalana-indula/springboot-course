package com.example.demo.controller;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    //define a field contains a list of students
    private List<Student> theStudentList;

    //define @PostConstruct to load the student data only once!
    @PostConstruct
    public void loadData(){
        this.theStudentList=new ArrayList<>();

        theStudentList.add(new Student("Poornima","Patel"));
        theStudentList.add(new Student("Mario","Rossi"));
        theStudentList.add(new Student("Mary","Smith"));
    }

    //define endpoints for "/student" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return this.theStudentList;
    }

    //Find a student by Id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        return this.theStudentList.get(studentId);

    }
}
