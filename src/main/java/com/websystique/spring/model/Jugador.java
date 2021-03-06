/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Jugador")
public class Jugador  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String nombre_usuario;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private Date cumple;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Personaje pj;
    // private set<Mesanje> mensajes;

    public Jugador() {
    }

    
    
    
    public long getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCumple() {
        return cumple;
    }

    public void setCumple(Date cumple) {
        this.cumple = cumple;
    }

    public Personaje getPj() {
        return pj;
    }

    public void setPj(Personaje pj) {
        this.pj = pj;
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
        final Jugador other = (Jugador) obj;
        if (this.id_jugador != other.id_jugador) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "id_jugador=" + id_jugador + "\n"
                + "nombre=" + nombre + "\n" +
                "nombre_usuario=" + nombre_usuario + "\n" +
                "cumple=" + cumple + "\n" + 
                "pj=" + "\n" + pj + '}';
    }
    
}
