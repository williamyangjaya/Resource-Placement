/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.repositories;

import com.mii.finalproject.entities.Employees;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author William Yangjaya
 */
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    
    List<Employees> findByJabatan(String jabatan);
}
