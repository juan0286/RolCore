/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "BonoExp")
public class BonoExp implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_bonoexp;
   
    @ManyToOne
    private Personaje pj;
    
    @Column(nullable = false)
    private int bono;
    
    @Column(nullable = false)
    private Date fecha;
    
    @Column
    private String motivo;
    
    @Column(nullable = false)
    private boolean aplicado;

    public BonoExp() {
    }

    public long getId_bonoexp() {
        return id_bonoexp;
    }

    public void setId_bonoexp(long id_bonoexp) {
        this.id_bonoexp = id_bonoexp;
    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAplicado() {
        return aplicado;
    }

    public void setAplicado(boolean aplicado) {
        this.aplicado = aplicado;
    }

    public Personaje getPj() {
        return pj;
    }

    public void setPj(Personaje pj) {
        this.pj = pj;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final BonoExp other = (BonoExp) obj;
        if (this.id_bonoexp != other.id_bonoexp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " *** BonoExp ***\n"  + bono + " Px.  Fecha= " + fecha + "  Aplicado=" + ((aplicado)? "Si" : "No") + "\nMotivo=" + motivo ;
    }
    
    
    
    
    
    
}
