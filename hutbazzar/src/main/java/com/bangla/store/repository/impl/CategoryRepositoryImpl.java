/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.repository.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import com.bangla.store.domain.Category;
import com.bangla.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

     

    public CategoryRepositoryImpl() {
    }
 

    @Override
    public void create(Category e) {
        sessionFactory.getCurrentSession().persist(e);
    }

    @Override
    public Category read(int id) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public void update(Category e) {
        sessionFactory.getCurrentSession().update(e);
    }

    @Override
    public void delete(int id) {
        Category cat = (Category) sessionFactory.getCurrentSession()
                .load(Category.class, id);
        if (null != cat) {
            sessionFactory.getCurrentSession().delete(cat);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getList() {
        List<Category> catList = sessionFactory.getCurrentSession()
                .createQuery("from Category").list();
        return catList;
    }

}
