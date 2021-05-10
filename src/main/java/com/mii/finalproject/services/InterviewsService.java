/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Interviews;
import com.mii.finalproject.repositories.ClientsRepository;
import com.mii.finalproject.repositories.EmployeesRepository;
import com.mii.finalproject.repositories.InterviewsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class InterviewsService {

    @Autowired
    InterviewsRepository interviewsRepository;

    @Autowired
    ClientsRepository clientsRepository;
    
    @Autowired
    EmployeesRepository employeesRepository;
    
    public List<Interviews> getAll() {
        return interviewsRepository.findAll();
    }

    public Interviews getById(Integer id) {
        Optional<Interviews> optional = interviewsRepository.findById(id);
        Interviews interviews = null;
        if (optional.isPresent()) {
            interviews = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + id);
        }
        return interviews;
    }

    public Interviews create(Interviews interviews) {
        return interviewsRepository.save(interviews);
    }

    public Interviews updateById(Integer id, Interviews interviewsDetails) {
        Interviews interviews = this.getById(id);
        interviews.setInterviewId(interviews.getInterviewId());
        interviews.setClientId(interviewsDetails.getClientId());
        interviews.setEmpId(interviewsDetails.getEmpId());
        interviews.setInterviewDate(interviewsDetails.getInterviewDate());
        interviews.setResultDate(interviewsDetails.getResultDate());
        interviews.setResult(interviewsDetails.getResult());
        interviews.setStatus(interviewsDetails.getStatus());
        interviews.setInterviewVia(interviewsDetails.getInterviewVia());
        interviews.setNote(interviewsDetails.getNote());
        
        return interviewsRepository.save(interviews);
    }
    
    public void deleteById(Integer id) {
        this.interviewsRepository.deleteById(id);
    }

}
