/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.repositories.DevelopersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class DevelopersService {

    @Autowired
    DevelopersRepository developersRepository;

    public List<Employees> getAllDeveloper() {
        return developersRepository.findByJabatan("Developer");
    }

    public Employees getById(Integer id) {
        Optional<Employees> optional = developersRepository.findById(id);
        Employees employees = null;
        if (optional.isPresent()) {
            employees = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employees;
    }

    public void insertDeveloperSkill(Integer empId, Integer skillId) {
        developersRepository.insertEmployeeSkill(empId, skillId);
    }

}
