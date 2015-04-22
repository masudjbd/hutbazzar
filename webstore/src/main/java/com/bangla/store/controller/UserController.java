/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.controller;

import com.bangla.store.domain.userAuthorities;
import com.bangla.store.domain.users;
import com.bangla.store.service.OrderService;
import com.bangla.store.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SW@RUP
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String AddUser(Model model) {

        users user=new users();
        //userAuthorities auth=new userAuthorities();
        model.addAttribute("users",user);
       // model.addAttribute("auth",auth);
        return "AddUser";//"redirect:/products";
    }

}
