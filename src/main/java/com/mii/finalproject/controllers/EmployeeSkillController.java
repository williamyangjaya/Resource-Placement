/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.dtos.EmployeeDTO;
import com.mii.finalproject.entities.EmpSkills;
import com.mii.finalproject.services.EmployeeSkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO-KL
 */
@RestController
@RequestMapping("/api/empskill")
public class EmployeeSkillController {

    @Autowired
    EmployeeSkillsService employeeSkillsService;

    @GetMapping("")
    public ResponseEntity<List<EmpSkills>> listEmpSkills() {
        return new ResponseEntity<>(employeeSkillsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> listEmpAllSkill() {
        return new ResponseEntity<>(employeeSkillsService.findEmployeeSkill(), HttpStatus.OK);
    }

    @GetMapping("/skill/{empId}")
    public ResponseEntity<List<EmpSkills>> showEmpSkillsPer(@PathVariable Integer empId) {
        return new ResponseEntity<>(employeeSkillsService.getEmployeeSkillById(empId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpSkills> showEmpSkills(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeSkillsService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EmpSkills> insertEmpSkills(@RequestBody EmpSkills empSkills) {
        return new ResponseEntity<>(employeeSkillsService.create(empSkills), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpSkills> updateEmpSkills(@PathVariable Integer id, @RequestBody EmpSkills empSkills) {
        return new ResponseEntity<>(employeeSkillsService.updateById(id, empSkills), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpSkill(@PathVariable Integer id) {
        employeeSkillsService.deleteById(id);
        return "Data berhasil dihapus";
    }

}
