/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.objetos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "CajaObjetos")
public class CajaObjetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cajaobj;

    @Column(nullable = false)
    private boolean pesable;

    @ManyToMany
    private List<ObjetoPortado> listaObj;

    public CajaObjetos() {
    }

    public long getId_cajaobj() {
        return id_cajaobj;
    }

    public void setId_cajaobj(long id_cajaobj) {
        this.id_cajaobj = id_cajaobj;
    }

    public boolean isPesable() {
        return pesable;
    }

    public void setPesable(boolean pesable) {
        this.pesable = pesable;
    }

    public List<ObjetoPortado> getListaObj() {
        return listaObj;
    }

    public void setListaObj(List<ObjetoPortado> listaObj) {
        this.listaObj = listaObj;
    }
    
    public void addObjeto(ObjetoPortado op) {
        if (this.listaObj == null){
            this.listaObj = new ArrayList<ObjetoPortado>();                    
        }
        this.listaObj.add(op);
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
        final CajaObjetos other = (CajaObjetos) obj;
        if (this.id_cajaobj != other.id_cajaobj) {
            return false;
        }
        return true;
    }

    
    
    
}
