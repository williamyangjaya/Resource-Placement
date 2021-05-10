/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.entities;

/**
 *
 * @author William Yangjaya
 */
public class Models {

    private String sendTo;
    private String subject;
    private String body;

    public Models() {
    }

    public Models(String sendTo, String subject, String body) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.body = body;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    
}
