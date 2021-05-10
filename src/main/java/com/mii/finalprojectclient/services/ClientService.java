/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.services;

import com.mii.finalprojectclient.configs.RequestFormat;
import com.mii.finalprojectclient.models.Clients;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author William Yangjaya
 */
@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/client")
    private String url;

    public List<Clients> getAll() {
        ResponseEntity<List<Clients>> response = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Clients>>() {
                });

        return response.getBody();
    }

    public Clients getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Clients.class).getBody();
    }

    public Clients create(Clients clients) {
        HttpEntity entity = new HttpEntity(clients, RequestFormat.createHeaders());
        ResponseEntity<Clients> res = restTemplate.exchange(url, HttpMethod.POST, entity, Clients.class);

        return res.getBody();
    }

    public Clients updateById(Integer id, Clients clients) {
        HttpEntity entity = new HttpEntity(clients, RequestFormat.createHeaders());
        ResponseEntity<Clients> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Clients.class);

        return res.getBody();
    }

    public String delete(Integer id) {
        HttpEntity entity = new HttpEntity(id, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

}
