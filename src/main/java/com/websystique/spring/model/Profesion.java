/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Profesion")
@XmlRootElement
public class Profesion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_profesion;
    
    @Column(nullable = false)
    private String nombre;

    
    
    public Profesion() {
    }

    public long getId_profesion() {
        return id_profesion;
    }

    public void setId_profesion(long id_profesion) {
        this.id_profesion = id_profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
