/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangla.store.domain.Employee;
import com.bangla.store.repository.EmployeeRepository;
import com.bangla.store.service.EmployeeService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

     

    public EmployeeServiceImpl() {
    }

     

    @Override
    public void create(Employee e) {
        employeeRepository.create(e);
    }

    @Override
    public Employee read(int id) {
        return employeeRepository.read(id);
    }

    @Override
    public void update(Employee e) {
        employeeRepository.update(e);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.getList();
    }

}
