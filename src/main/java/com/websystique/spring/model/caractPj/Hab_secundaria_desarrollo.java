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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */

@Entity
@Table(name = "Hab_secundaria_desarrollo")
@XmlRootElement
public class Hab_secundaria_desarrollo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_h_s_desa;
    
    @ManyToOne
    private Hab_secundaria hab_secundaria;
    
    @Column
    private int valor;

    public long getId_h_s_desa() {
        return id_h_s_desa;
    }

    public void setId_h_s_desa(long id_h_s_desa) {
        this.id_h_s_desa = id_h_s_desa;
    }

    public Hab_secundaria getHab_secundaria() {
        return hab_secundaria;
    }

    public void setHab_secundaria(Hab_secundaria hab_secundaria) {
        this.hab_secundaria = hab_secundaria;
    }

    public int getValor() {        
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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
        final Hab_secundaria_desarrollo other = (Hab_secundaria_desarrollo) obj;
        if (this.id_h_s_desa != other.id_h_s_desa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hab. Secundaria=" + ", valor=" + valor + "\n" + hab_secundaria ;
    }
    
    
    
}
