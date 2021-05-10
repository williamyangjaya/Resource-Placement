/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William Yangjaya
 */
@Entity
@Table(name = "interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interviews.findAll", query = "SELECT i FROM Interviews i")})
public class Interviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "interview_id")
    private Integer interviewId;
    @Basic(optional = false)
    @Column(name = "interview_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interviewDate;
    @Column(name = "result_date")
    @Temporal(TemporalType.DATE)
    private Date resultDate;
    @Basic(optional = false)
    @Column(name = "result")
    private String result;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "interview_via")
    private String interviewVia;
    @Lob
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employees empId;
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Clients clientId;

    public Interviews() {
    }

    public Interviews(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public Interviews(Integer interviewId, Date interviewDate, String result, String status, String interviewVia) {
        this.interviewId = interviewId;
        this.interviewDate = interviewDate;
        this.result = result;
        this.status = status;
        this.interviewVia = interviewVia;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public Date getInterviewDate(){
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterviewVia() {
        return interviewVia;
    }

    public void setInterviewVia(String interviewVia) {
        this.interviewVia = interviewVia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Employees getEmpId() {
        return empId;
    }

    public void setEmpId(Employees empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interviewId != null ? interviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interviews)) {
            return false;
        }
        Interviews other = (Interviews) object;
        if ((this.interviewId == null && other.interviewId != null) || (this.interviewId != null && !this.interviewId.equals(other.interviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.finalproject.entities.Interviews[ interviewId=" + interviewId + " ]";
    }
    
}
