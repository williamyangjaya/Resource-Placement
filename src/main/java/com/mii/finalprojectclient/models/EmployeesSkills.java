/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class EmployeesSkills {

    private Integer empId;
    private Integer skillId;

    public EmployeesSkills(Integer empId, Integer skillId) {
        this.empId = empId;
        this.skillId = skillId;
    }

    public EmployeesSkills() {
    }

}
