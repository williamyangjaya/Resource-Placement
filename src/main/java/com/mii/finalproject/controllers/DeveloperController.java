/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.services.DevelopersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api/developer")
public class DeveloperController {

    @Autowired
    DevelopersService developersService;

    @GetMapping("")
    public ResponseEntity<List<Employees>> listDeveloper() {
        return new ResponseEntity<>(developersService.getAllDeveloper(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employees> showDeveloper(@PathVariable Integer id) {
        return new ResponseEntity<>(developersService.getById(id), HttpStatus.OK);
    }
    
    @PostMapping("")
    public String insertDeveloperSkill() {
         developersService.insertDeveloperSkill(1, 1);
         return "sukses";
    }

}
