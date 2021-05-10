/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.AuthRequest;
import com.mii.finalprojectclient.services.AuthService;
import com.mii.finalprojectclient.services.EmployeeService;
import com.mii.finalprojectclient.services.InterviewService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William Yangjaya
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private InterviewService interviewService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();
        if (!(authenticated instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/dashboard";
        }
        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("auth") AuthRequest auth) {
        String redirectUrl = "";

        if (authService.loginProcess(auth)) {
            redirectUrl = "redirect:/dashboard";
        } else {
            redirectUrl = "redirect:/login?error";
        }
        return redirectUrl;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("interviews", interviewService.getAll());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();

        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        for (Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "redirect:/login?logout";
    }
   @GetMapping("/user")
    public @ResponseBody String getUserId() {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        return authent.getPrincipal().toString();
    }

}