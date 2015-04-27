/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.controller;

import com.bangla.store.domain.Authorities;
import com.bangla.store.domain.Users;
import com.bangla.store.service.OrderService;
import com.bangla.store.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author SW@RUP
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String AddUser(@ModelAttribute Users users, Model model) {
        model.addAttribute("userAuthorities", userService.getAuthorities());
//        List<Authorities> uLis = userService.getAuthorities();
//        for (Authorities uA :uLis ) {
//            System.out.println(" ===Masud=== " + uA.getAuthority());
//        }
//                    System.out.println(" ===Masud=== >> ");

        return "users/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String SaveUser(@ModelAttribute("users") @Valid Users users, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()) {
            return "users/add";
        } else {
            userService.create(users);
            ra.addFlashAttribute("message", "Saved successfully.");
            return "redirect:/user";
        }
    }

}
