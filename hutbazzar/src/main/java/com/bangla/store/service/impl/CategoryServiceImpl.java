/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangla.store.domain.Category;
import com.bangla.store.repository.CategoryRepository;
import com.bangla.store.service.CategoryService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

     

    public CategoryServiceImpl() {
    }

     

    @Override
    public void create(Category e) {
        categoryRepository.create(e);
    }

    @Override
    public Category read(int id) {
        return categoryRepository.read(id);
    }

    @Override
    public void update(Category e) {
        categoryRepository.update(e);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<Category> getList() {
        return categoryRepository.getList();
    }

}
