/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.repositories;

import com.mii.finalproject.entities.Employees;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author William Yangjaya
 */
@Repository
public interface DevelopersRepository extends JpaRepository<Employees, Integer> {

    List<Employees> findByJabatan(String Jabatan);

    @Modifying
    @Query(value = "INSERT INTO emp_skill(emp_id, skill_id) "
            + "VALUES(:empId, :skillId)", nativeQuery = true)
    @Transactional
    void insertEmployeeSkill(@Param("empId") Integer empId, @Param("skillId") Integer skillId);
    
}
