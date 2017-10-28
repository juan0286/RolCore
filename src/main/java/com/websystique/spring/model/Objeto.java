/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Objeto")
public class Objeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_objeto;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "APODO")
    private String apodo;
    
    @Column(name = "DEGRADADO_ACTUAL", nullable = false)
    private int degradado_actual;  // ptos de vida actuales
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_TIPOOBJETO")
    private TipoObjeto tipoObjeto;
    // private set<efecto> efectos

    public Objeto() {
    }

    public long getId_objeto() {
        return id_objeto;
    }

    public void setId_objeto(long id_objeto) {
        this.id_objeto = id_objeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDegradado_actual() {
        return degradado_actual;
    }

    public void setDegradado_actual(int degradado_actual) {
        this.degradado_actual = degradado_actual;
    }

    public TipoObjeto getTipo() {
        return tipoObjeto;
    }

    public void setTipo(TipoObjeto tipo) {
        this.tipoObjeto = tipo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public TipoObjeto getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(TipoObjeto tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }
    
    

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Objeto))
			return false;
		Objeto other = (Objeto) obj;
		if (id_objeto != other.id_objeto)
			return false;		
		return id_objeto == other.getId_objeto();
	}
    
    
}
