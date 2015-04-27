/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.service;

import java.util.List;
import com.bangla.store.domain.Employee;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface EmployeeService {

    public List<Employee> getList();

    public void create(Employee e);

    public Employee read(int id);

    public void update(Employee e);

    public void delete(int id);
}
