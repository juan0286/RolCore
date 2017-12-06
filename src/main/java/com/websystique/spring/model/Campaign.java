/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import com.websystique.spring.model.campaign.Historia;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Jugador> jugadores;

    @ManyToOne(fetch = FetchType.EAGER)
    private Master master;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Mundo mundo;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Historia historia;

    @Column(unique = true)
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<CampaignAccessRequest> cars;

    public Campaign() {
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getNombreURL() {
        try {
            return URLEncoder.encode(nombre.replace(" ", "_"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Campaign.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador j) {
        if (jugadores == null)
            jugadores = new HashSet<Jugador>();
        jugadores.add(j);       
            
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Set<CampaignAccessRequest> getCars() {
        return cars;
    }

    public void setCars(Set<CampaignAccessRequest> cars) {
        this.cars = cars;
    }

    
    
    public void addCar(CampaignAccessRequest car){
        if (cars != null){
            cars.add(car);
        }
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
        final Campaign other = (Campaign) obj;
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

}
