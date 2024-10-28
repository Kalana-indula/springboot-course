package com.example.demo.controller;

import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.exceptions.error.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {


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
