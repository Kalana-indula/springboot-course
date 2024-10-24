package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.exceptions.error.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        //check if studentId against the list size
        if((studentId>=theStudentList.size())||(studentId<0)){
            throw new StudentNotFoundException("Student Not Found - "+studentId);
        }

        return this.theStudentList.get(studentId);

    }

    //Create a exception handler method
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a stdudent error response
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    //add another method to handle any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create student error response
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
