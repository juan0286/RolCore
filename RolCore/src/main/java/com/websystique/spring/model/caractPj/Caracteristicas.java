/*
 * To change this license header, choose License Headers inte Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inte the editor.
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
@Table(name = "caracteristicas")
public class Caracteristicas  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_car;
    
    @Column(nullable = false)
    private int fue;
    
    @Column(nullable = false)
    private int agi;
    
    @Column(nullable = false)
    private int con;
    
    @Column(nullable = false)
    private int inte;
    
    @Column(nullable = false)
    private int i;
    
    @Column(nullable = false)
    private int pre;
    
    @Column(nullable = false)
    private int apa;

    public Caracteristicas() {
    }

    public long getId_car() {
        return id_car;
    }

    public void setId_car(long id_car) {
        this.id_car = id_car;
    }

    public int getFue() {
        return fue;
    }

    public void setFue(int fue) {
        this.fue = fue;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getApa() {
        return apa;
    }

    public void setApa(int apa) {
        this.apa = apa;
    }

    
    
    
    @Override
    public String toString() {
        return "Caracteristicas{" + "id_car=" + id_car + ", fue=" + fue + ", agi=" + agi + ", con=" + con + ", in=" + inte + ", i=" + i + ", pre=" + pre + ", apa=" + apa + '}';
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
        final Caracteristicas other = (Caracteristicas) obj;
        if (this.id_car != other.id_car) {
            return false;
        }
        return true;
    }
    
    
    
}
