/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.services;

import com.mii.finalprojectclient.configs.RequestFormat;
import com.mii.finalprojectclient.models.Interviews;
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
public class InterviewService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/interview")
    private String url;

    public List<Interviews> getAll() {
        ResponseEntity<List<Interviews>> response = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Interviews>>() {
                });

        return response.getBody();
    }

    public Interviews getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Interviews.class).getBody();
    }

    public Interviews create(Interviews interviews) {
        HttpEntity entity = new HttpEntity(interviews, RequestFormat.createHeaders());
        ResponseEntity<Interviews> res = restTemplate.exchange(url, HttpMethod.POST, entity, Interviews.class);
        return res.getBody();
    }

    public Interviews updateById(Integer id, Interviews interviews) {
        HttpEntity entity = new HttpEntity(interviews, RequestFormat.createHeaders());
        ResponseEntity<Interviews> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, Interviews.class);
       
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
