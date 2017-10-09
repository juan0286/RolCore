/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */

@Entity
@Table(name = "Campaign")
public class Campaign implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_campaign;
    
    @Column(nullable = false)
    private String nombre;   
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)    
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Jugador> jugadores;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Mundo mundo;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Master master;        
    
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    private Set<BonoExp> bonosExp;

    public Campaign() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador j){
        jugadores.add(j);
    }
    
    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Mundo getMundo() {
        return mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }

    public long getId_campaign() {
        return id_campaign;
    }

    public void setId_campaign(long id_campaign) {
        this.id_campaign = id_campaign;
    }

    
    
    
//    public Set<BonoExp> getBonosExp() {
//        return bonosExp;
//    }
//
//    public void setBonosExp(Set<BonoExp> bonosExp) {
//        this.bonosExp = bonosExp;
//    }

//    public void addBonoExp(BonoExp be){
//        bonosExp.add(be);
//    }
   
//    public Master getMaster() {
//        return master;
//    }
//
//    public void setMaster(Master master) {
//        this.master = master;
//    }

        

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
        final Campaign other = (Campaign) obj;
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

    
}

