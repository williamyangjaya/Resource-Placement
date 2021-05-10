/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.Employees;
import com.mii.finalprojectclient.services.DeveloperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William Yangjaya
 */
@Controller
@RequestMapping("developer")
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", developerService.getAll());
        return "developer";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Employees> getAllProcess() {
        return developerService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Employees getById(@PathVariable("id") Integer id) {
        return developerService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Employees create(@RequestBody Employees employees) {
        return developerService.create(employees);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Employees update(@PathVariable("id") Integer id, @RequestBody Employees employees) {
        return developerService.updateById(id, employees);
    }

    @DeleteMapping("/{id}")
    public Employees delete(@PathVariable("id") Integer id) {
        return developerService.delete(id);
    }

}
