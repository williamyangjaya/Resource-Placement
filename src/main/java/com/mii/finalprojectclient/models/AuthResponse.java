/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import java.util.List;
import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class AuthResponse {

    private String id;
    private List<String> authorities;

    public AuthResponse(String id, List<String> authorities) {
        this.id = id;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }
}
