/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.objetos;

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
@Table(name = "BolsaDeMonedas")
public class BolsaDeMonedas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_bolsaDeMonedas;
    
    @Column(nullable = false)
    private int mOro;
    
    @Column(nullable = false)
    private int mPlata;
    
    @Column(nullable = false)
    private int mBronce;

    public BolsaDeMonedas() {
    }

    public long getId_bolsaDeMonedas() {
        return id_bolsaDeMonedas;
    }

    public void setId_bolsaDeMonedas(long id_bolsaDeMonedas) {
        this.id_bolsaDeMonedas = id_bolsaDeMonedas;
    }

    public int getmOro() {
        return mOro;
    }

    public void setmOro(int mOro) {
        this.mOro = mOro;
    }

    public int getmPlata() {
        return mPlata;
    }

    public void setmPlata(int mPlata) {
        this.mPlata = mPlata;
    }

    public int getmBronce() {
        return mBronce;
    }

    public void setmBronce(int mBronce) {
        this.mBronce = mBronce;
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
        final BolsaDeMonedas other = (BolsaDeMonedas) obj;
        if (this.id_bolsaDeMonedas != other.id_bolsaDeMonedas) {
            return false;
        }
        return true;
    }
    
    
    
}
