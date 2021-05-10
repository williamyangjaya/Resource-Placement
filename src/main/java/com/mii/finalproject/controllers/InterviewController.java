/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.entities.Interviews;
import com.mii.finalproject.services.InterviewsService;
import com.mii.finalproject.services.NotificationsService;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    InterviewsService interviewsService;

    @GetMapping("")
    public ResponseEntity<List<Interviews>> listInterview() {       
        return new ResponseEntity<>(interviewsService.getAll(), HttpStatus.OK);
    }

    @Autowired
    private NotificationsService notificationsService;

    @GetMapping("/{id}")
    public ResponseEntity<Interviews> showInterview(@PathVariable Integer id) {
        return new ResponseEntity<>(interviewsService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Interviews> insertInterviews(@RequestBody Interviews interviews) throws MessagingException {
        notificationsService.sendEmail(interviews);
        return new ResponseEntity<>(interviewsService.create(interviews), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interviews> updateInterviews(@PathVariable Integer id, @RequestBody Interviews interviews) {
        return new ResponseEntity<>(interviewsService.updateById(id, interviews), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteInterviews(@PathVariable Integer id) {
        interviewsService.deleteById(id);
        return "Data berhasil dihapus";
    }

}
