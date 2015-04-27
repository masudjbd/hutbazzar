/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.repository.impl;

import com.bangla.store.domain.Authorities;
import com.bangla.store.domain.Users;
import com.bangla.store.repository.UserRepository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SW@RUP
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public UserRepositoryImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Users> getUserList() {
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    @Override
    public void create(Users user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void delete(int userId) {
        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, userId);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(Users user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override     @SuppressWarnings("unchecked")
    public List<Authorities> getAuthorities() {
        return sessionFactory.getCurrentSession().createQuery("from Authorities").list();
    }

}
