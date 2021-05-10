/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.dtos.EmployeeDTO;
import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.services.EmployeesService;
import com.mii.finalproject.services.EmployeeSkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeesService employeesService;
    
    @Autowired
    EmployeeSkillsService skillEmployeeService;

    @GetMapping("")
    public ResponseEntity<List<Employees>> listEmployee() {
        return new ResponseEntity<>(employeesService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/developer")
    public ResponseEntity<List<Employees>> listDeveloper() {
        return new ResponseEntity<>(employeesService.getAllDeveloper(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> showEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeesService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Employees> insertEmployee(@RequestBody Employees employees) {
        return new ResponseEntity<>(employeesService.create(employees), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employees, @PathVariable Integer id) {
        return new ResponseEntity<>(employeesService.updateById(id, employees), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteInterviews(@PathVariable Integer id) {
        employeesService.deleteById(id);
        return "Data berhasil dihapus";
    }

}
