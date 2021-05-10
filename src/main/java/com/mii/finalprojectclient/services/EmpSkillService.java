/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.services;

import com.mii.finalprojectclient.configs.RequestFormat;
import com.mii.finalprojectclient.models.EmpSkill;
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
 * @author LENOVO-KL
 */
@Service
public class EmpSkillService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/api/empskill")
    private String url;

    public List<EmpSkill> getAll() {
        ResponseEntity<List<EmpSkill>> response = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<EmpSkill>>() {
                });
        return response.getBody();
    }

    public EmpSkill getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, EmpSkill.class).getBody();
    }

    public List<EmpSkill> getByEmpId(Integer empId) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeaders());
        ResponseEntity<List<EmpSkill>> res = restTemplate.exchange(url + "/skill/" + empId, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<EmpSkill>>() {
        });
        return res.getBody();
    }

    public EmpSkill create(EmpSkill empSkill) {
        HttpEntity entity = new HttpEntity(empSkill, RequestFormat.createHeaders());
        ResponseEntity<EmpSkill> res = restTemplate.exchange(url, HttpMethod.POST, entity, EmpSkill.class);

        return res.getBody();
    }

    public EmpSkill updateById(Integer id, EmpSkill empSkill) {
        HttpEntity entity = new HttpEntity(empSkill, RequestFormat.createHeaders());
        ResponseEntity<EmpSkill> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity, EmpSkill.class);
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
