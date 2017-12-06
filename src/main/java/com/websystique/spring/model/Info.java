/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */

@Entity
@Table(name = "Info")
@XmlRootElement
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_info;    
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false)
    private String texto;
    
    @Column(nullable = false)
    boolean soloMaster;

    public Info() {
    }

    public long getId_info() {
        return id_info;
    }

    public void setId_info(long id_info) {
        this.id_info = id_info;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isSoloMaster() {
        return soloMaster;
    }

    public void setSoloMaster(boolean soloMaster) {
        this.soloMaster = soloMaster;
    }
    
    
    
}
