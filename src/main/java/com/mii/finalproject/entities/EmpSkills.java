/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William Yangjaya
 */
@Entity
@Table(name = "emp_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpSkills.findAll", query = "SELECT e FROM EmpSkills e")})
public class EmpSkills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empskill_id")
    private Integer empskillId;
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employees empId;
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Skills skillId;

    public EmpSkills() {
    }

    public EmpSkills(Integer empskillId) {
        this.empskillId = empskillId;
    }

    public Integer getEmpskillId() {
        return empskillId;
    }

    public void setEmpskillId(Integer empskillId) {
        this.empskillId = empskillId;
    }

    public Skills getSkillId() {
        return skillId;
    }

    public void setSkillId(Skills skillId) {
        this.skillId = skillId;
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
        hash += (empskillId != null ? empskillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpSkills)) {
            return false;
        }
        EmpSkills other = (EmpSkills) object;
        if ((this.empskillId == null && other.empskillId != null) || (this.empskillId != null && !this.empskillId.equals(other.empskillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.finalproject.entities.EmpSkills[ empskillId=" + empskillId + " ]";
    }

}
