/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.caractPj;

import com.websystique.spring.model.Profesion;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "ProfesionDesarrollo")
public class ProfesionDesarrollo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_profDesarrollo;

    @ManyToOne
    private Profesion profesion;

    @Column(nullable = false)
    private int experiencia;

    @Column(nullable = false)
    private int nivel;

    public ProfesionDesarrollo() {
    }

    public long getId_profDesarrollo() {
        return id_profDesarrollo;
    }

    public void setId_profDesarrollo(long id_profDesarrollo) {
        this.id_profDesarrollo = id_profDesarrollo;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
}