/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.services;

import com.mii.finalproject.entities.Clients;
import com.mii.finalproject.repositories.ClientsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class ClientsService {
    
    @Autowired
    ClientsRepository clientsRepository;
    
    public List<Clients> getAll(){
        return clientsRepository.findAll();
    }
    
    public Clients getById(Integer id) {
        Optional<Clients> optional = clientsRepository.findById(id);
        Clients clients = null;
        if (optional.isPresent()) {
            clients = optional.get();
        } else {
            throw new RuntimeException(" Contact not found for id :: " + id);
        }
        return clients;
    }
    
    public Clients create(Clients clients) {
        return clientsRepository.save(clients);
    }
    
    public Clients updateById(Clients clientsDetails, Integer id) {
        Clients clients = this.getById(id);
        clients.setClientId(clients.getClientId());
        clients.setClientName(clientsDetails.getClientName());
        clients.setInstansi(clientsDetails.getInstansi());
        clients.setEmail(clientsDetails.getEmail());
        clients.setIndustryType(clientsDetails.getIndustryType());
        clients.setLocation(clientsDetails.getLocation());
        return clientsRepository.save(clients);
    }
    
    public void deleteById(Integer id) {
        this.clientsRepository.deleteById(id);
    }
    
}
