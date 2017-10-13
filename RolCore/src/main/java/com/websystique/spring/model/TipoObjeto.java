/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

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
@Table(name = "tipoobjeto")
public class TipoObjeto implements Serializable {    
    
    @Id
    @Column(name = "ID_TIPOOBJETO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipoObjeto;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "TAM_STND", nullable = false)
    private float tam_stnd; // cm
    
    @Column(name = "PESO_STND", nullable = false)
    private float peso_stnd; // gramos
    
    @Column(name = "DEGRADADO", nullable = false)
    private float degradado;  // pts de vida que pierde por asalto
    
    @Column(name = "DURABILIDAD_STND", nullable = false)
    private float durabilidad_stnd;  // ptos de vida del objeto > 100 integro. < a 100 el porcentaje de integridad

    public TipoObjeto() {
    }
    
    public int getId_tipoObjeto() {
        return id_tipoObjeto;
    }

    public void setId_tipoObjeto(int id_tipoObjeto) {
        this.id_tipoObjeto = id_tipoObjeto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTam_stnd() {
        return tam_stnd;
    }

    public void setTam_stnd(float tam_stnd) {
        this.tam_stnd = tam_stnd;
    }

    public float getPeso_stnd() {
        return peso_stnd;
    }

    public void setPeso_stnd(float peso_stnd) {
        this.peso_stnd = peso_stnd;
    }

    public float getDegradado() {
        return degradado;
    }

    public void setDegradado(float degradado) {
        this.degradado = degradado;
    }

    public float getDurabilidad_stnd() {
        return durabilidad_stnd;
    }

    public void setDurabilidad_stnd(float durabilidad_stnd) {
        this.durabilidad_stnd = durabilidad_stnd;
    }
    
    
    

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoObjeto))
			return false;
		TipoObjeto other = (TipoObjeto) obj;		
		return id_tipoObjeto == other.getId_tipoObjeto();
	}

    @Override
    public String toString() {
        return "TipoObjeto{" + "id_tipoObjeto=" + id_tipoObjeto + ", nombre=" + nombre + ", tam_stnd=" + tam_stnd + ", peso_stnd=" + peso_stnd + ", degradado=" + degradado + ", durabilidad_stnd=" + durabilidad_stnd + '}';
    }
    
    
}
