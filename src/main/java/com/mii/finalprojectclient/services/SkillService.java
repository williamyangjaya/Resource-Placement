/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.services;

import com.mii.finalprojectclient.configs.RequestFormat;
import com.mii.finalprojectclient.models.Skills;
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
public class SkillService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/skill")
    private String url;

    public List<Skills> getAll() {
        ResponseEntity<List<Skills>> response = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Skills>>() {
                });

        return response.getBody();
    }

    public Skills getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Skills.class).getBody();
    }

    public Skills create(Skills skills) {
        HttpEntity entity = new HttpEntity(skills, RequestFormat.createHeaders());
        ResponseEntity<Skills> res = restTemplate.exchange(url, HttpMethod.POST, entity, Skills.class);

        return res.getBody();
    }

    public Skills updateById(Integer id, Skills skills) {
        HttpEntity entity = new HttpEntity(skills, RequestFormat.createHeaders());
        ResponseEntity<Skills> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Skills.class);

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
