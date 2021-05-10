/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.dtos.UserLoginDTO;
import com.mii.finalproject.dtos.UserSessionDTO;
import com.mii.finalproject.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mii.finalproject.repositories.UsersRepository;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    MyUserDetailsService myUserDetailsService;
    
    @PostMapping("/login")
    public UserSessionDTO login(@RequestBody UserLoginDTO userLoginDTO) throws Exception {
        return myUserDetailsService.login(userLoginDTO);
    }

}
