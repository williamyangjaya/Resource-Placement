/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.Candidate;
import com.mii.finalprojectclient.models.Employees;
import com.mii.finalprojectclient.services.CandidateService;
import com.mii.finalprojectclient.services.EmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CandidateService candidateService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee";
    }

    @GetMapping("/get-all-skill")
    public @ResponseBody
    List<Candidate> getAllProcessCandidate() {
        return candidateService.getAll();
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Employees> getAllProcess() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Employees getById(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Employees create(@RequestBody Employees employees) {
        return employeeService.create(employees);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Employees update(@PathVariable("id") Integer id, @RequestBody Employees employees) {
        return employeeService.updateById(id, employees);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable("id") Integer id) {
        return employeeService.delete(id);
    }

}
