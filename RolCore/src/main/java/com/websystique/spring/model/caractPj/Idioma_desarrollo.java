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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "idioma_desarrollo")
public class Idioma_desarrollo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_idioma_des;
    
    @ManyToOne
    private Idioma idioma;
    
    @Column(nullable = false)
    private int valor;
    
    public Idioma_desarrollo() {
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
        final Idioma_desarrollo other = (Idioma_desarrollo) obj;
        if (this.id_idioma_des != other.id_idioma_des) {
            return false;
        }
        return true;
    }

    public long getId_idioma_des() {
        return id_idioma_des;
    }

    public void setId_idioma_des(long id_idioma_des) {
        this.id_idioma_des = id_idioma_des;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getValor() {        
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    

    @Override
    public String toString() {
        return "\n-----" +  idioma + "\ngrado=" + valor ;
    }
    
    
}
