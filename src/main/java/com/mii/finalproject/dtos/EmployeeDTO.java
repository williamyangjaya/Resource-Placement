/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.dtos;

import com.mii.finalproject.entities.EmpSkills;
import java.util.List;
import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class EmployeeDTO {

    private Integer id;
    private List<EmpSkills> empskills;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, List<EmpSkills> empskills) {
        this.id = id;
        this.empskills = empskills;
    }

}
