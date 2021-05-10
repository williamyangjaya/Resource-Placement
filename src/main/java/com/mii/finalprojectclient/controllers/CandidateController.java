/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.Employees;
import com.mii.finalprojectclient.services.CandidateService;
import com.mii.finalprojectclient.services.ClientService;
import com.mii.finalprojectclient.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William Yangjaya
 */
@Controller
@RequestMapping("candidate")
public class CandidateController {

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    ClientService clientService;
    
    @Autowired
    CandidateService candidateService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("candidates", candidateService.getAll());
        return "candidate";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Employees> getAllProcess() {
        return employeeService.getAll();
    }

//    @GetMapping("/{id}")
//    public @ResponseBody
//    Employees getById(@PathVariable("id") Integer id) {
//        return employeeService.getById(id);
//    }
//
//    @PostMapping
//    public @ResponseBody
//    Employees create(@RequestBody Employees employees) {
//        return employeeService.create(employees);
//    }
//
//    @PutMapping("/{id}")
//    public @ResponseBody
//    Employees update(@PathVariable("id") Integer id, @RequestBody Employees employees) {
//        return employeeService.updateById(id, employees);
//    }
//
//    @DeleteMapping("/{id}")
//    public @ResponseBody
//    String delete(@PathVariable("id") Integer id) {
//        return employeeService.delete(id);
//    }

}
