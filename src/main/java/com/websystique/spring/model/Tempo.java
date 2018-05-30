/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Tempo")
public class Tempo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id_tempo;
    
    @OneToOne
    private Campaign campaign;
    
    @Column
    private Date inicio;    // Se crea la primera vez    
    
    @Column
    private Date fin; // Seteo cuando ya finalizo    
    
    @Column
    private long transcurso;  // cantidad de asaltos que se avanzo    
    
    @Column
    private long caducidad;    
    
    @Formula(" 100 - (transcurso * 100) / caducidad ")
    @Column
    private int porcentaje;

    public Tempo() {
    }

    public long getId_tempo() {
        return id_tempo;
    }

    public void setId_tempo(long id_tempo) {
        this.id_tempo = id_tempo;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public long getTranscurso() {
        return transcurso;
    }

    public void setTranscurso(long transcurso) {
        this.transcurso = transcurso;
    }

    public long getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(long caducidad) {
        this.caducidad = caducidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
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
        final Tempo other = (Tempo) obj;
        if (this.id_tempo != other.id_tempo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tempo{" + "id_tempo=" + id_tempo + ", campaign=" + campaign + ", inicio=" + inicio + ", transcurso=" + transcurso + ", caducidad=" + caducidad + ", porcentaje=" + porcentaje + '}';
    }
    
    
    
    
    
    
    
}
