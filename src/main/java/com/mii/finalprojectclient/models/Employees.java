/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalprojectclient.models;

import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author William Yangjaya
 */
@Data
public class Employees {

    private Integer empId;
    private String name;
    private String gender;
    private Date birthDate;
    private String email;
    private String jabatan;

    public Employees() {
    }

    public Employees(Employees employees) {
        this.empId = employees.getEmpId();
        this.name = employees.getName();
        this.gender = employees.getGender();
        this.birthDate = employees.getBirthDate();
        this.email = employees.getEmail();
        this.jabatan = employees.getJabatan();        
    }

}
