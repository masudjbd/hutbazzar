/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.repository.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import com.bangla.store.domain.Employee;
import com.bangla.store.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private SessionFactory sessionFactory;

     

    public EmployeeRepositoryImpl() {
    }

     

    @Override
    public void create(Employee e) {
        sessionFactory.getCurrentSession().persist(e);
    }

    @Override
    public Employee read(int id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee e) {
        sessionFactory.getCurrentSession().update(e);
    }

    @Override
    public void delete(int id) {
        Employee empl = (Employee) sessionFactory.getCurrentSession()
                .load(Employee.class, id);
        if (null != empl) {
            sessionFactory.getCurrentSession().delete(empl);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getList() {
        List<Employee> emplList = sessionFactory.getCurrentSession()
                .createQuery("from Employee").list();
        return emplList;
    }

}
