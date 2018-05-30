/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.combate;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author TiranoJuan
 */

@Embeddable
public class CodeCritico implements Serializable {

    private static final long serialVersionUID = 24844114L;
    
    @Column(length = 2)
    private int position;
    
    @Column(length = 1)
    private String letraCrit;
    
    @Column(length = 1)
    private String tabla;

    public CodeCritico() {
    }

    public CodeCritico(int pos, String letra, String tabla) {
        this.position = pos;
        this.letraCrit = letra;
        this.tabla = tabla;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.position);
        hash = 59 * hash + Objects.hashCode(this.letraCrit);
        hash = 59 * hash + Objects.hashCode(this.tabla);
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
        final CodeCritico other = (CodeCritico) obj;
        if (this.position != other.position) {
            return false;
        }
        if ((this.letraCrit == null) ? (other.letraCrit != null) : !this.letraCrit.equals(other.letraCrit)) {
            return false;
        }
        if ((this.tabla == null) ? (other.tabla != null) : !this.tabla.equals(other.tabla)) {
            return false;
        }
        return true;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getLetraCrit() {
        return letraCrit;
    }

    public void setLetraCrit(String letraCrit) {
        this.letraCrit = letraCrit;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    
    
    @Override
    public String toString() {
        return position + "-" + letraCrit + "-" + tabla;
    }

}
