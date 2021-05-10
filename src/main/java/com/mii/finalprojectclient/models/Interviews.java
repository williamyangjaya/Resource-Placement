/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class Interviews {

    private Integer interviewId;
    private Date interviewDate;
    private Date resultDate;
    private String result;
    private String status;
    private String interviewVia;
    private String note;
    private Clients clientId;
    private Employees empId;

    public Interviews() {
    }

    public Interviews(Integer interviewId, Date interviewDate, Date resultDate, String result, String status, String interviewVia, String note, Clients clientId, Employees empId) {
        this.interviewId = interviewId;
        this.interviewDate = interviewDate;
        this.resultDate = resultDate;
        this.result = result;
        this.status = status;
        this.interviewVia = interviewVia;
        this.note = note;
        this.clientId = clientId;
        this.empId = empId;
    }

}
