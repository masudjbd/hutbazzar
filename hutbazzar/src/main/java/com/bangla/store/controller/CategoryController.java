/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import com.bangla.store.domain.Category;
import com.bangla.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

//    @InitBinder
//    public void initialiseBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//        binder.registerCustomEditor(Date.class, "officeStart", new CustomDateEditor(timeFormat, true));
//        binder.registerCustomEditor(Date.class, "officeEnd", new CustomDateEditor(timeFormat, true));
//        binder.setDisallowedFields("presentAddress",
//                "picture", "nid", "permanentAddress",
//                "fatherName", "emergencyContact", "employeeTelExt", "employeeDistrictId", "employeeAreaId", "employeeDesignationId", "employeeUserPassword",
//                "employeeDepartmentId", "employeeGroupId", "employeeTotalSalary", "employeeStatus", "employeeRemarks", "dhakacomId", "shiftingId", "cLObtain", "cLSpent", "mLObtain", "mLSpent", "eLObtain", "eLSpent", "employeeCurrentStatus", "reason");
//
//        binder.setAllowedFields("id", "employeeUserName", "employeeName", "employeeEmail", "employeeMobile", "dateOfBirth", "officeStart", "officeEnd", "effectDate");
//
//    }
    @RequestMapping
    public String list(Model model) {
        model.addAttribute("categories", categoryService.getList());
        return "category/list";
    }
    /*
     * add page view
     */
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@ModelAttribute("category") Category category) {
        return "category/add";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("category") @Valid Category category, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()) {
            return "category/add";
        } else {
            categoryService.create(category);
            ra.addFlashAttribute("message", "Successfully added item.");
            
            return "redirect:/category";
        }
        
    }
    
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.read(id));
        return "category/details";
        
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.read(id));
        return "category/edit";
        
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateDetails(Model model, @Valid Category category, @PathVariable int id,
            BindingResult br, RedirectAttributes rAttributes) {
        
        if (br.hasErrors()) {
            model.addAttribute("category", category);
            return "category/edit";
        } else {
            categoryService.update(category);
            rAttributes.addFlashAttribute("message", "Successfully updated item");
            return "redirect:/category";
            
        }
        
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes) {
        categoryService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully remoted item");
        return "redirect:/category";
        
    }
}
