/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Skills;
import com.mii.finalproject.repositories.SkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class SkillsService {
    
    @Autowired
    SkillsRepository skillsRepository;
    
    public List<Skills> getAll(){
        return skillsRepository.findAll();
    }
    
    public Skills getById(Integer id) {
        Optional<Skills> optional = skillsRepository.findById(id);
        Skills skills = null;
        if (optional.isPresent()) {
            skills = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + id);
        }
        return skills;
    }
    
    public Skills create(Skills skills) {
        return skillsRepository.save(skills);
    }
    
    public Skills updateById(Skills skillsDetails, Integer id) {
        Skills skills = this.getById(id);
        skills.setSkillId(skills.getSkillId());
        skills.setLabel(skillsDetails.getLabel());
        return skillsRepository.save(skills);
    }
    
    public void deleteById(Integer id) {
        this.skillsRepository.deleteById(id);
    }
    
}
