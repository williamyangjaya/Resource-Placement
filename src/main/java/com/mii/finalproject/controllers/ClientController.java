/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.controllers;

import com.mii.finalproject.entities.Clients;
import com.mii.finalproject.services.ClientsService;
import java.util.List;
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
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientsService clientsService;

    @GetMapping("")
    public ResponseEntity<List<Clients>> listClient() {
        return new ResponseEntity<>(clientsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> showClient(@PathVariable Integer id) {
        return new ResponseEntity<>(clientsService.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Clients> insertClient(@RequestBody Clients clients) {
        return new ResponseEntity<>(clientsService.create(clients), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateClient(@RequestBody Clients clients, @PathVariable Integer id) {
        return new ResponseEntity<>(clientsService.updateById(clients, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer id) {
        clientsService.deleteById(id);
        return "Data berhasil dihapus";
    }

}
