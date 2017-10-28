/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import com.websystique.spring.model.Personaje;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Jugador")
@XmlRootElement
public class Jugador  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;
    
    @Column(nullable = false)
    private String id_firebase;
            
    @Column(nullable = false)
    private int perfil;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String nombre_usuario;
    
    @Column(nullable = false)
    private String password;
    
    @Column
    private Date cumple;
    
    @OneToOne(cascade={CascadeType.ALL}) 
    private Personaje pj;
    // private set<Mesanje> mensajes;

    public Jugador() {
    }
    
    public static final int PERFIL_ADMIN = 0;
    public static final int PERFIL_JUGADOR = 1;
    public static final int PERFIL_MODERADOR = 2;    
    
    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }    
    
    
    public long getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getId_firebase() {
        return id_firebase;
    }

    public void setId_firebase(String id_firebase) {
        this.id_firebase = id_firebase;
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
