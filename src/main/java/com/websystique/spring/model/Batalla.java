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
@Table(name = "Batalla")
public class Batalla implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_batalla;

    public long getId_batalla() {
        return id_batalla;
    }

    public void setId_batalla(long id_batalla) {
        this.id_batalla = id_batalla;
    }
}
