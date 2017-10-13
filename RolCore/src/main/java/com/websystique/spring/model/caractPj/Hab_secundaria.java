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
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "hab_secundaria")
public class Hab_secundaria implements Serializable{
    
    
    public static final int TIPO_ME = 0;
    public static final int TIPO_MM = 1;
    public static final int TIPO_BO = 2;
    public static final int TIPO_PE = 3;
    public static final int TIPO_BD = 4;
    
    public static final int MOD_FUE = 0;
    public static final int MOD_AGI = 1;
    public static final int MOD_CON = 2;
    public static final int MOD_INTE = 3;
    public static final int MOD_I = 4;
    public static final int MOD_PRE = 5;
    public static final int MOD_APA = 6;
    public static final int MOD_XXX = 7;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_hs;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private int tipo;
    
    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private int modificador;

    public Hab_secundaria() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Hab_secundaria other = (Hab_secundaria) obj;
        if (this.id_hs != other.id_hs) {
            return false;
        }
        return true;
    }

    public long getId_hs() {
        return id_hs;
    }

    public void setId_hs(long id_hs) {
        this.id_hs = id_hs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getModificador() {
        return modificador;
    }

    public void setModificador(int modificador) {
        this.modificador = modificador;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", tipo=" + tipo + ", modificador=" + modificador + "\nDescripcion=" + descripcion;
    }
    
    
}
