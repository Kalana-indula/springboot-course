package com.example.demo.exceptions.error;

public class StudentErrorResponse {

    private Integer status;
    private String message;
    private Long timeStamp;

    //constructors

    public StudentErrorResponse() {
    }

    //setters

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    //getters

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
