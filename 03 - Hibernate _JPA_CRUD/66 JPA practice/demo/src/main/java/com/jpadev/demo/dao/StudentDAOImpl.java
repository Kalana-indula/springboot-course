package com.jpadev.demo.dao;

import com.jpadev.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Defines the class as a repositoyry spring component
@Repository
public class StudentDAOImpl implements StudentDAO{


    private EntityManager entityManager;

    //Inject entity manager object
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    @Transactional //handle and manage transactions
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //@Transactional annotationis not required for a read only operation
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
//        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastName desc",Student.class);
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create a quary
        TypedQuery<Student> theQuery=entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName= :theData",Student.class);

        //setparameter
        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    //@Transactional is required as update process takes in place
    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);
    }

    //Update multiple students
    @Override
    @Transactional
    public Integer updateStudent() {

        int numRowsUpdated=entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();

        return numRowsUpdated;
    }

    //delete student
    @Override
    @Transactional
    public void delete(Integer id) {
        //find the student to be deleted
        Student student=entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(student);
    }
}
