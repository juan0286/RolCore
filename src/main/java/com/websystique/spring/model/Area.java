/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

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
@Table(name = "Area")
public class Area implements Serializable{
    
    public static final int TIPO_AREA_CONTINENTE = 0;
    public static final int TIPO_AREA_PAIS = 1;
    public static final int TIPO_AREA_CIUDAD = 2;
    public static final int TIPO_AREA_ALDEA = 3;
    public static final int TIPO_AREA_PUEBLO= 4;
    
    public static final int TIPO_AREA_BOSQUE = 101;
    public static final int TIPO_AREA_PRADERA = 102;
    public static final int TIPO_AREA_JUNGLA = 103;
    public static final int TIPO_AREA_MONTE = 104;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_area;

    @Column(nullable = false)
    private int tipoDeArea;
    /*
    Si es un area de tipo continente debe tener si o si Climatologia, 
    Si es pais, puede heredar de continente o tener otra.
    Si es ciudad, pueblo o menor, debe heredar si o si.   
    
    */
    public long getId_area() {
        return id_area;
    }

    public void setId_area(long id_area) {
        this.id_area = id_area;
    }

    public Area() {
    }
    
    
    
}


