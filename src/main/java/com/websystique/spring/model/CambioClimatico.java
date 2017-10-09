/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import java.io.Serializable;
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
@Table(name = "CambioClimatico")
public class CambioClimatico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cc;

    public long getId_cc() {
        return id_cc;
    }

    public void setId_cc(long id_cc) {
        this.id_cc = id_cc;
    }

    public CambioClimatico() {
    }
    
    
    
}
