/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.combate;

/**
 *
 * @author TiranoJuan
 */
public class Damage {
    
    
    private int pv;
    
    private Critico critico;

    public Damage() {
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }


    public Critico getCritico() {
        return critico;
    }

    public void setCritico(Critico critico) {
        this.critico = critico;
    }
    
    
}
