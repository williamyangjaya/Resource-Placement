/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.Interviews;
import com.mii.finalprojectclient.services.ClientService;
import com.mii.finalprojectclient.services.EmployeeService;
import com.mii.finalprojectclient.services.InterviewService;
import java.time.LocalDate;
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
@RequestMapping("interview")
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @Autowired
    ClientService clientService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("interviews", interviewService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "interview";
    }
    
    @GetMapping("/accept")
    public String getAllAccept(Model model) {
        model.addAttribute("interviews", interviewService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "interview-accept";
    }
    
    @GetMapping("/reject")
    public String getAllReject(Model model) {
        model.addAttribute("interviews", interviewService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "interview-reject";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Interviews> getAllProcess() {
        return interviewService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Interviews getById(@PathVariable("id") Integer id) {
        return interviewService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Interviews create(@RequestBody Interviews interviews) {
        return interviewService.create(interviews);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Interviews update(@PathVariable("id") Integer id, @RequestBody Interviews interviews) {
        System.out.println(interviews);
        return interviewService.updateById(id, interviews);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable("id") Integer id) {
        return interviewService.delete(id);
    }

}
