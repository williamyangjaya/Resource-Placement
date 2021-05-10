/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class Clients {

    private Integer clientId;
    private String clientName;
    private String instansi;
    private String email;
    private String industryType;
    private String location;

    public Clients() {
    }

    public Clients(Integer clientId, String clientName, String instansi, String email, String industryType, String location) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.instansi = instansi;
        this.email = email;
        this.industryType = industryType;
        this.location = location;
    }

}
