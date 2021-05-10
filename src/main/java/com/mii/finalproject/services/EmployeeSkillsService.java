/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.dtos.EmployeeDTO;
import com.mii.finalproject.entities.EmpSkills;
import com.mii.finalproject.entities.Employees;
import com.mii.finalproject.entities.MyUserDetails;
import com.mii.finalproject.repositories.EmployeeSkillsRepository;
import com.mii.finalproject.repositories.EmployeesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO-KL
 */
@Service
public class EmployeeSkillsService {

    @Autowired
    EmployeeSkillsRepository employeeSkillsRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    public List<EmpSkills> getAll() {
        return employeeSkillsRepository.findAll();
    }

    public EmpSkills getById(Integer id) {
        Optional<EmpSkills> optional = employeeSkillsRepository.findById(id);
        EmpSkills empSkills = null;
        if (optional.isPresent()) {
            empSkills = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + id);
        }
        return empSkills;
    }

    public EmpSkills create(EmpSkills empSkills) {
        return employeeSkillsRepository.save(empSkills);
    }

    public EmpSkills updateById(Integer id, EmpSkills empSkillsDetails) {
        EmpSkills empSkills = this.getById(id);
        empSkills.setEmpskillId(empSkills.getEmpskillId());
        empSkills.setSkillId(empSkillsDetails.getSkillId());
        empSkills.setEmpId(empSkillsDetails.getEmpId());
        return employeeSkillsRepository.save(empSkills);
    }

    public void deleteById(Integer id) {
        this.employeeSkillsRepository.deleteById(id);
    }

    public List<EmpSkills> getSkill(Integer empId){
       List<EmpSkills> empSkills = employeesRepository.findById(empId).get().getEmpSkillsList();
       return empSkills;
    }
    
    public List<EmpSkills> getEmployeeSkillById(Integer empId) {
        List<EmpSkills> empSkills = employeesRepository.findById(empId).get().getEmpSkillsList();
        return empSkills;

    }

    public List<EmployeeDTO> findEmployeeSkill() {
        List<EmployeeDTO> response = new ArrayList<>();
        for (Employees employee : employeesRepository.findAll()) {
            response.add(new EmployeeDTO(employee.getEmpId(), employeeSkillsRepository.findByEmpId_empId((employee.getEmpId()))));
        }

        return response;
    }
}
