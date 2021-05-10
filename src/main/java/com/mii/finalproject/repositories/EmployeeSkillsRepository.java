/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.repositories;

import com.mii.finalproject.entities.EmpSkills;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO-KL
 */
@Repository
public interface EmployeeSkillsRepository extends JpaRepository<EmpSkills, Integer>{
    List<EmpSkills> findByEmpId_empId(Integer empId);
}