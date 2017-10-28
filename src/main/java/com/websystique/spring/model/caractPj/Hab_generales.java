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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Hab_generales")
@XmlRootElement
public class Hab_generales implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_hg;
    
    @Column(nullable = false)
    private int trepar;
    
    @Column(nullable = false)
    private int montar;
    
    @Column(nullable = false)
    private int nadar;
    
    @Column(nullable = false)
    private int rastrear;

    public Hab_generales() {
    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Hab_generales other = (Hab_generales) obj;
        if (this.id_hg != other.id_hg) {
            return false;
        }
        return true;
    }

    public long getId_hg() {
        return id_hg;
    }

    public void setId_hg(long id_hg) {
        this.id_hg = id_hg;
    }

    public int getTrepar() {
        return trepar;
    }

    public void setTrepar(int trepar) {
        this.trepar = trepar;
    }

    public int getMontar() {
        return montar;
    }

    public void setMontar(int montar) {
        this.montar = montar;
    }

    public int getNadar() {
        return nadar;
    }

    public void setNadar(int nadar) {
        this.nadar = nadar;
    }

    public int getRastrear() {
        return rastrear;
    }

    public void setRastrear(int rastrear) {
        this.rastrear = rastrear;
    }

    @Override
    public String toString() {
        return "----Hab_generales\n" + "trepar=" + trepar + "\n" + "montar=" + montar + "\n" + "nadar=" + nadar + "\n" + "rastrear=" + rastrear + '}';
    }
    
    
    
}
