package com.demo.restdemo.rest;

import com.demo.restdemo.dao.EmployeeDao;
import com.demo.restdemo.entity.Employee;
import com.demo.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //expose a single employee by id
    //path variable name should be equal to the argument
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee theEmployee=employeeService.findById(id);

        if(theEmployee==null){
            throw new RuntimeException("Employee id not found - "+id);
        }

        return theEmployee;
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item.... instead of update

        theEmployee.setId(0);

        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }


    //add mapping for update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        //save an existing employee
        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for DELETE/ employees/{employeei=Id} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee=employeeService.findById(employeeId);

        //throw exception
        if(tempEmployee==null){
            throw new RuntimeException("Employee not found - "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Delete employee id - "+employeeId;
    }
}
