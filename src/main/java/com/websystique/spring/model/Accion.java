/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Accion")
@XmlRootElement
public class Accion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_accion;
    
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    @JoinColumn(name = "ID_CAMPAIGN")
    Campaign campaign;

    public long getId_accion() {
        return id_accion;
    }

    public void setId_accion(long id_accion) {
        this.id_accion = id_accion;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Accion other = (Accion) obj;
        if (this.id_accion != other.id_accion) {
            return false;
        }
        return true;
    }
    
    
    
}
