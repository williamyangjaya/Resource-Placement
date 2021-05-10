/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import lombok.Data;

/**
 *
 * @author LENOVO-KL
 */
@Data
public class EmpSkill {

    private Integer empskillId;
    private Skills skillId;
    private Employees empId;

    public EmpSkill() {
    }

    public EmpSkill(Integer empskillId, Skills skillId, Employees empId) {
        this.empskillId = empskillId;
        this.skillId = skillId;
        this.empId = empId;
    }

}
