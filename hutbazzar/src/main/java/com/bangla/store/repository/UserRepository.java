/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.repository;

import com.bangla.store.domain.Authorities;
import com.bangla.store.domain.Users;
import java.util.List;

/**
 *
 * @author SW@RUP
 */
public interface UserRepository {

    public List<Users> getUserList();
    public List<Authorities> getAuthorities();
    
    public void create(Users user);

    public void delete(int userId);

    public void update(Users user);
}
