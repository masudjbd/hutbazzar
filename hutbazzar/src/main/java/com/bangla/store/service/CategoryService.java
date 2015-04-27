/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.service;

import java.util.List;
import com.bangla.store.domain.Category;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface CategoryService {

    public List<Category> getList();

    public void create(Category e);

    public Category read(int id);

    public void update(Category e);

    public void delete(int id);
}
