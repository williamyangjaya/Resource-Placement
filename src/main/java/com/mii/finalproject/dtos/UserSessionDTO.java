/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.dtos;

import java.util.List;

/**
 *
 * @author William Yangjaya
 */
public class UserSessionDTO {

    private Integer id;

    private String username;

    List<String> authorities;

    public UserSessionDTO() {
    }

    public UserSessionDTO(Integer id, String username, List<String> authorities) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

}
