/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.entities.Skills;
import com.mii.finalproject.services.SkillsService;
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
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    SkillsService skillsService;

    @GetMapping("")
    public ResponseEntity<List<Skills>> listClient() {
        return new ResponseEntity<>(skillsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skills> showClient(@PathVariable Integer id) {
        return new ResponseEntity<>(skillsService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Skills> insertClient(@RequestBody Skills skills) {
        return new ResponseEntity<>(skillsService.create(skills), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skills> updateClient(@RequestBody Skills skills, @PathVariable Integer id) {
        return new ResponseEntity<>(skillsService.updateById(skills, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer id) {
        skillsService.deleteById(id);
        return "Data berhasil dihapus";
    }

}
