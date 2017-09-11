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
@Table(name = "Hab_subterfugio")
public class Hab_subterfugio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_hs;
    
    @Column(nullable = false)
    private int emboscar;
    
    @Column(nullable = false)
    private int acecharEsconderse;
    
    @Column(nullable = false)
    private int abrirCerraduras;
    
    @Column(nullable = false)
    private int desactivarTrampas;

    public Hab_subterfugio() {
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
        final Hab_subterfugio other = (Hab_subterfugio) obj;
        if (this.id_hs != other.id_hs) {
            return false;
        }
        return true;
    }

    public long getId_hs() {
        return id_hs;
    }

    public void setId_hs(long id_hs) {
        this.id_hs = id_hs;
    }

    public int getEmboscar() {
        return emboscar;
    }

    public void setEmboscar(int emboscar) {
        this.emboscar = emboscar;
    }

    public int getAcecharEsconderse() {
        return acecharEsconderse;
    }

    public void setAcecharEsconderse(int acecharEsconderse) {
        this.acecharEsconderse = acecharEsconderse;
    }

    public int getAbrirCerraduras() {
        return abrirCerraduras;
    }

    public void setAbrirCerraduras(int abrirCerraduras) {
        this.abrirCerraduras = abrirCerraduras;
    }

    public int getDesactivarTrampas() {
        return desactivarTrampas;
    }

    public void setDesactivarTrampas(int desactivarTrampas) {
        this.desactivarTrampas = desactivarTrampas;
    }

    @Override
    public String toString() {
        return "----Hab_subterfugio{\n" + "emboscar=" + emboscar + "\n" + "acecharEsconderse=" + acecharEsconderse + "\n" + "abrirCerraduras=" + abrirCerraduras + "\n" + "desactivarTrampas=" + desactivarTrampas + '}';
    }
    
    
}
