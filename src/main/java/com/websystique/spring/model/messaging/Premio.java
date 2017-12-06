/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.messaging;

import com.websystique.spring.model.bono.Bono;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.objetos.CajaObjetos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Premio")
public class Premio {

    public enum TipoPremio {
        BONO, EXP, OBJETO
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_p;
    
    @ManyToOne
    private Bono bono;
    
    @OneToOne
    private BonoExp bonoExp;
    
    @ManyToOne
    private CajaObjetos objetos;

    public Premio() {
    }

    public long getId_p() {
        return id_p;
    }

    public void setId_p(long id_p) {
        this.id_p = id_p;
    }

    public Bono getBono() {
        return bono;
    }

    public void setBono(Bono bono) {
        this.bono = bono;
    }

    public BonoExp getBonoExp() {
        return bonoExp;
    }

    public void setBonoExp(BonoExp bonoExp) {
        this.bonoExp = bonoExp;
    }

    public CajaObjetos getObjetos() {
        return objetos;
    }

    public void setObjetos(CajaObjetos objetos) {
        this.objetos = objetos;
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
        final Premio other = (Premio) obj;
        if (this.id_p != other.id_p) {
            return false;
        }
        return true;
    }
    
    
    
}
