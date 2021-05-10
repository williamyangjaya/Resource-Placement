/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.EmpSkill;
import com.mii.finalprojectclient.services.EmpSkillService;
import com.mii.finalprojectclient.services.EmployeeService;
import com.mii.finalprojectclient.services.SkillService;
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
 * @author LENOVO-KL
 */
@Controller
@RequestMapping("empskill")
public class EmpSkillController {

    @Autowired
    EmpSkillService empSkillService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SkillService skillService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("skills", skillService.getAll());
        model.addAttribute("empskills", empSkillService.getAll());
        return "empskill";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("skills", skillService.getAll());
        model.addAttribute("empskills", empSkillService.getAll());
        return "form-empskill";
    }

    @GetMapping("/skill/{empId}")
    public @ResponseBody
    List<EmpSkill> getByempId(@PathVariable("empId") Integer empId) {
        return empSkillService.getByEmpId(empId);
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<EmpSkill> getAllProcess() {
        return empSkillService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    EmpSkill getById(@PathVariable("id") Integer id) {
        return empSkillService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    EmpSkill create(@RequestBody EmpSkill empSkill) {
        return empSkillService.create(empSkill);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    EmpSkill update(@PathVariable("id") Integer id, @RequestBody EmpSkill empSkill) {
        return empSkillService.updateById(id, empSkill);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable("id") Integer id) {
        return empSkillService.delete(id);

    }

}
