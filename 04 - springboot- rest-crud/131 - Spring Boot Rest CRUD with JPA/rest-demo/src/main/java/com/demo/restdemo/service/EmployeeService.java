package com.demo.restdemo.service;

import com.demo.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    //delete an existing employee
    void deleteById(int theId);
}
