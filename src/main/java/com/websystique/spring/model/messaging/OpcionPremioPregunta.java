/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.messaging;

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
@Table(name = "OpcionPremioPregunta")
public class OpcionPremioPregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_opp;
    
    @Column(nullable = false)
    private String sentencia;
    
    @Column(nullable = false)  
    private boolean correcta;

    
    
    
    
    public OpcionPremioPregunta() {
    }

    
    
    public long getId_opp() {
        return id_opp;
    }

    public void setId_opp(long id_opp) {
        this.id_opp = id_opp;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
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
        final OpcionPremioPregunta other = (OpcionPremioPregunta) obj;
        if (this.id_opp != other.id_opp) {
            return false;
        }
        return true;
    }
    
    
    
    
}
