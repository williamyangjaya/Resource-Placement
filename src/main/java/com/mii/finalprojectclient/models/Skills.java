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
public class Skills {

    private Integer skillId;
    private String label;

    public Skills(Skills skills) {
        this.skillId = skills.getSkillId();
        this.label = skills.getLabel();
    }

    public Skills() {
    }

}
