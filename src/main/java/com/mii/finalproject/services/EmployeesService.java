/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.repositories.EmployeesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employees> getAll() {
        return employeesRepository.findAll();
    }
    
    public List<Employees> getAllDeveloper() {
        return employeesRepository.findByJabatan("Developer");
    }

    public Employees getById(Integer id) {
        Optional<Employees> optional = employeesRepository.findById(id);
        Employees employees = null;
        if (optional.isPresent()) {
            employees = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employees;
    }

    public Employees create(Employees employees) {
        return employeesRepository.save(employees);
    }

    public Employees updateById(Integer id, Employees employeesDetails) {
        Employees employees = this.getById(id);
        employees.setEmpId(employees.getEmpId());
        employees.setName(employeesDetails.getName());
        employees.setEmail(employeesDetails.getEmail());
        employees.setGender(employeesDetails.getGender());
        employees.setBirthDate(employeesDetails.getBirthDate());
        employees.setJabatan(employeesDetails.getJabatan());
        return employeesRepository.save(employees);
    }

    public void deleteById(Integer id) {
        this.employeesRepository.deleteById(id);
    }
    
}
