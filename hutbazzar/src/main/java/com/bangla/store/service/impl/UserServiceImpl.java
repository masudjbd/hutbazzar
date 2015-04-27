/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.service.impl;

import com.bangla.store.domain.Authorities;
import com.bangla.store.domain.Users;
import com.bangla.store.repository.UserRepository;
import com.bangla.store.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SW@RUP
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<Users> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public List<Authorities> getAuthorities() {
        return userRepository.getAuthorities();
    }

    @Override
    public void create(Users user) {
        userRepository.create(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.delete(userId);
    }

    @Override
    public void update(Users user) {
        userRepository.update(user);
    }

   

}
