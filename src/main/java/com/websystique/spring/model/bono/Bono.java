/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.bono;

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
@Table(name = "Bono")
public class Bono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_bono;

    @Column
    private String titulo;
    
    @Column
    private String descripcion;

    public Bono() {
    }

    public long getId_bono() {
        return id_bono;
    }

    public void setId_bono(long id_bono) {
        this.id_bono = id_bono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final Bono other = (Bono) obj;
        if (this.id_bono != other.id_bono) {
            return false;
        }
        return true;
    }
    
    
    
}
