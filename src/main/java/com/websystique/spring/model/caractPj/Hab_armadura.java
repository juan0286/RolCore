/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.caractPj;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Hab_armadura")
public class Hab_armadura implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_ha;
    
    @Column(nullable = false)
    private int sa;
    
    @Column(nullable = false)
    private int c;
    
    @Column(nullable = false)
    private int ce;
    
    @Column(nullable = false)
    private int cm;
    
    @Column(nullable = false)
    private int co;    

    public Hab_armadura() {
    }

    public long getId_ha() {
        return id_ha;
    }

    public void setId_ha(long id_ha) {
        this.id_ha = id_ha;
    }

    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getCe() {
        return ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    @Override
    public String toString() {
        return "----Hab_armadura\n" + "sa=" + sa + "\n" + "c=" + c + "\n" + "ce=" + ce + "\n" + "cm=" + cm + "\n" + "co=" + co + '}';
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hab_armadura other = (Hab_armadura) obj;
        if (this.id_ha != other.id_ha) {
            return false;
        }
        return true;
    }
    
    
}
