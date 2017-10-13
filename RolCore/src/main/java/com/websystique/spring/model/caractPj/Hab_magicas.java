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
@Table(name = "hab_magicas")
public class Hab_magicas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_hm;
    
    @Column(nullable = false)
    private int leerRunas;
    
    @Column(nullable = false)
    private int usarObjetos;
    
    @Column(nullable = false)
    private int sortilegiosDirgidos;
    
    @Column(nullable = false)
    private int sortilegiosBase;

    public Hab_magicas() {
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
        final Hab_magicas other = (Hab_magicas) obj;
        if (this.id_hm != other.id_hm) {
            return false;
        }
        return true;
    }

    public long getId_hm() {
        return id_hm;
    }

    public void setId_hm(long id_hm) {
        this.id_hm = id_hm;
    }

    public int getLeerRunas() {
        return leerRunas;
    }

    public void setLeerRunas(int leerRunas) {
        this.leerRunas = leerRunas;
    }

    public int getUsarObjetos() {
        return usarObjetos;
    }

    public void setUsarObjetos(int usarObjetos) {
        this.usarObjetos = usarObjetos;
    }

    public int getSortilegiosDirgidos() {
        return sortilegiosDirgidos;
    }

    public void setSortilegiosDirgidos(int sortilegiosDirgidos) {
        this.sortilegiosDirgidos = sortilegiosDirgidos;
    }

    public int getSortilegiosBase() {
        return sortilegiosBase;
    }

    public void setSortilegiosBase(int sortilegiosBase) {
        this.sortilegiosBase = sortilegiosBase;
    }

    @Override
    public String toString() {
        return "----Hab_magicas\n" + "leerRunas=" + leerRunas + "\n" + "usarObjetos=" + usarObjetos + "\n" + "sortilegiosDirgidos=" + sortilegiosDirgidos + "\n" + "sortilegiosBase=" + sortilegiosBase + '}';
    }
    
    
            
}
