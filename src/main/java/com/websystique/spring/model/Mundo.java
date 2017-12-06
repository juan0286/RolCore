/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import com.websystique.spring.model.objetos.Objeto;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */

@Entity
@Table(name = "Mundo")
public class Mundo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mundo;
    
    @Column(nullable = false)
    private String nombre;
        
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Objeto> objetos;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<CambioClimatico> climatologia;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Pnj> pnjs;
    
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    Set<Area> areas;
     
    @Column(nullable = false)
    private Date fecha_rol;
    
    public Mundo() {
    }

    public long getId_mundo() {
        return id_mundo;
    }

    public void setId_mundo(long id_mundo) {
        this.id_mundo = id_mundo;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

   
    public Set<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(Set<Objeto> objetos) {
        this.objetos = objetos;
    }

    public Set<CambioClimatico> getClimatologia() {
        return climatologia;
    }

    public void setClimatologia(Set<CambioClimatico> climatologia) {
        this.climatologia = climatologia;
    }

    public Date getFecha_rol() {
        return fecha_rol;
    }

    public void setFecha_rol(Date fecha_rol) {
        this.fecha_rol = fecha_rol;
    }

    public Set<Pnj> getPnjs() {
        return pnjs;
    }

    public void setPnjs(Set<Pnj> pnjs) {
        this.pnjs = pnjs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
    @Override
    public String toString() {
        return "Mundo{" + "id_mundo=" + id_mundo + ", areas=" + areas + ", objetos=" + objetos + ", climatologia=" + climatologia + ", pnjs=" + pnjs + ", fecha_rol=" + fecha_rol + '}';
    }
    
    
    
    
}
