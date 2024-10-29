package com.demo.restdemo.dao;


import com.demo.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    //find an employee by ID
    Employee findById(int theId);

    //update an existing employee
    Employee save(Employee theEmployee);

    //delete an existing employee
    void deleteById(int theId);

}
