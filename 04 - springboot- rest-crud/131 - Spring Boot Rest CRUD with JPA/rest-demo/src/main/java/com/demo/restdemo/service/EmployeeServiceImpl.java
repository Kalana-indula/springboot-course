package com.demo.restdemo.service;

import com.demo.restdemo.dao.EmployeeRepository;
import com.demo.restdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
//        return employeeRepository.findById(theId).orElse(null);
        
        //Following method is also preferred
        Optional<Employee> result=employeeRepository.findById(theId);

        Employee theEmployee=null;

        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw new RuntimeException("Did not find employee id - "+theId);
        }

        return theEmployee;
    }

    //@Transactional annotation is not required as JPA repository implicitly handles it
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
