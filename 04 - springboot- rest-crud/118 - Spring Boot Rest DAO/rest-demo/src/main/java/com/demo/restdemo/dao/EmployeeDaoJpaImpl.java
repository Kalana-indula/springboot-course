package com.demo.restdemo.dao;

import com.demo.restdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{

    //define field for entitymanager
    private EntityManager entityManager;

    //setting up a constructor injection
    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee",Employee.class);

        //execute the query and get the result list
        List<Employee> employees=theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //return found employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save employee
        Employee dbEmployee=entityManager.merge(theEmployee);

        //return updated employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find employee by id
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //delete the employee
        entityManager.remove(theEmployee);

    }


}
