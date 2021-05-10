/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.controllers;

import com.mii.finalprojectclient.models.Clients;
import com.mii.finalprojectclient.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William Yangjaya
 */
@Controller
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("clients", clientService.getAll());
        return "client";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Clients> getAllProcess() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Clients getById(@PathVariable("id") Integer id) {
        return clientService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Clients create(@RequestBody Clients clients) {
        System.out.println(clients);
        return clientService.create(clients);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Clients update(@PathVariable("id") Integer id, @RequestBody Clients clients) {
        return clientService.updateById(id, clients);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    String delete(@PathVariable("id") Integer id) {
        return clientService.delete(id);

    }

}
