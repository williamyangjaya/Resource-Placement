/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.services;

import com.mii.finalprojectclient.configs.RequestFormat;
import com.mii.finalprojectclient.models.Employees;
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
public class DeveloperService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/developer")
    private String url;

    public List<Employees> getAll() {
        ResponseEntity<List<Employees>> response = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Employees>>() {
                });

        return response.getBody();
    }

    public Employees getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Employees.class).getBody();
    }

    public Employees create(Employees employees) {
        HttpEntity entity = new HttpEntity(employees, RequestFormat.createHeaders());
        ResponseEntity<Employees> res = restTemplate.exchange(url, HttpMethod.POST, entity, Employees.class);

        return res.getBody();
    }

    public Employees updateById(Integer id, Employees employees) {
        HttpEntity entity = new HttpEntity(employees, RequestFormat.createHeaders());
        ResponseEntity<Employees> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Employees.class);

        return res.getBody();
    }

    public Employees delete(Integer id) {
        ResponseEntity<Employees> res = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, null, Employees.class);
        return res.getBody();
    }

}
