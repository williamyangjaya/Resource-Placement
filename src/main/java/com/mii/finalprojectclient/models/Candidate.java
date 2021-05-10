/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class Candidate {

    private Integer id;
    private List<EmpSkill> empskills;

    public Candidate(Integer id, List<EmpSkill> empskills) {
        this.id = id;
        this.empskills = empskills;
    }

    public Candidate() {
    }

}
