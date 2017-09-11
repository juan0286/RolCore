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
@Table(name = "Hab_armas")
public class Hab_armas implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_har;
    
    @Column(nullable = false)
    private int filo;
    
    @Column(nullable = false)
    private int contundentes;
    
    @Column(nullable = false)
    private int dosManos;
    
    @Column(nullable = false)
    private int arrojadizas;
    
    @Column(nullable = false)
    private int proyectiles;
    
    @Column(nullable = false)
    private int asta;
    
    @Column(nullable = false)
    private int pelea;

    public Hab_armas() {
    }

    public long getId_har() {
        return id_har;
    }

    public void setId_har(long id_har) {
        this.id_har = id_har;
    }

    public int getFilo() {
        return filo;
    }

    public void setFilo(int filo) {
        this.filo = filo;
    }

    public int getContundentes() {
        return contundentes;
    }

    public void setContundentes(int contundentes) {
        this.contundentes = contundentes;
    }

    public int getDosManos() {
        return dosManos;
    }

    public void setDosManos(int dosManos) {
        this.dosManos = dosManos;
    }

    public int getArrojadizas() {
        return arrojadizas;
    }

    public void setArrojadizas(int arrojadizas) {
        this.arrojadizas = arrojadizas;
    }

    public int getProyectiles() {
        return proyectiles;
    }

    public void setProyectiles(int proyectiles) {
        this.proyectiles = proyectiles;
    }

    public int getAsta() {
        return asta;
    }

    public void setAsta(int asta) {
        this.asta = asta;
    }

    public int getPelea() {
        return pelea;
    }

    public void setPelea(int pelea) {
        this.pelea = pelea;
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
        final Hab_armas other = (Hab_armas) obj;
        if (this.id_har != other.id_har) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "----Hab_armas\n" + "filo=" + filo + "\n" + "contundentes=" + contundentes + "\n" + "dosManos=" + dosManos + "\n" + "arrojadizas=" + arrojadizas + "\n" + "proyectiles=" + proyectiles + "\n" + "asta=" + asta + "\n" + "pelea=" + pelea + '}';
    }
    
    
    
}
