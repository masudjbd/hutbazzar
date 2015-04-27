/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.repository;

import com.bangla.store.domain.Category;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface CategoryRepository {

    public List<Category> getList();
    public void create(Category c);
    public Category read(int id);
    public void update(Category c);
    public void delete(int c);
}
