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
@Table(name = "Resistencias")
public class Resistencias implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_resist;
    
    @Column(nullable = false)
    private int escencia;
    
    @Column(nullable = false)
    private int canalizacion;
    
    @Column(nullable = false)
    private int mentalismo;
    
    @Column(nullable = false)
    private int venenos;
    
    @Column(nullable = false)
    private int enfermedades;
    
    @Column(nullable = false)
    private int frio;
    
    @Column(nullable = false)
    private int calor;

    public Resistencias() {
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
        final Resistencias other = (Resistencias) obj;
        if (this.id_resist != other.id_resist) {
            return false;
        }
        return true;
    }

    public long getId_resist() {
        return id_resist;
    }

    public void setId_resist(long id_resist) {
        this.id_resist = id_resist;
    }

    public int getEscencia() {
        return escencia;
    }

    public void setEscencia(int escencia) {
        this.escencia = escencia;
    }

    public int getCanalizacion() {
        return canalizacion;
    }

    public void setCanalizacion(int canalizacion) {
        this.canalizacion = canalizacion;
    }

    public int getMentalismo() {
        return mentalismo;
    }

    public void setMentalismo(int mentalismo) {
        this.mentalismo = mentalismo;
    }

    public int getVenenos() {
        return venenos;
    }

    public void setVenenos(int venenos) {
        this.venenos = venenos;
    }

    public int getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(int enfermedades) {
        this.enfermedades = enfermedades;
    }

    public int getFrio() {
        return frio;
    }

    public void setFrio(int frio) {
        this.frio = frio;
    }

    public int getCalor() {
        return calor;
    }

    public void setCalor(int calor) {
        this.calor = calor;
    }

    @Override
    public String toString() {
        return "\n----Resistencias\n" + "escencia=" + escencia + "\n" + "canalizacion=" + canalizacion + "\n" + "mentalismo=" + mentalismo + "\n" + "venenos=" + venenos + "\n" + "enfermedades=" + enfermedades + "\n" + "frio=" + frio + "\n" + "calor=" + calor;
    }
    
    
}
