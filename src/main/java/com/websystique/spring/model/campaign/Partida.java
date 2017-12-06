/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.campaign;

import com.websystique.spring.model.Batalla;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Partida")
@XmlRootElement
public class Partida {
    
    public enum Estado {PROGRAMADA,INICIADA, EN_CURSO, FINALIZADA, CANCELADA } ;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partida;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column
    private String resumen;       
    
    @Column
    private Date fechaProgramada;
    
    @Column
    private Date fecha;
    
    @Column
    private Date fechaInicioMundoRol;
    
    @Column
    private Date fechaFinMundoRol;
    
    @Column(nullable = false)
    private Estado estado;

    @OneToMany
    private Set<Batalla> batallas;
    
    public Partida() {
    }

    public long getId_partida() {
        return id_partida;
    }

    public void setId_partida(long id_partida) {
        this.id_partida = id_partida;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaInicioMundoRol() {
        return fechaInicioMundoRol;
    }

    public void setFechaInicioMundoRol(Date fechaInicioMundoRol) {
        this.fechaInicioMundoRol = fechaInicioMundoRol;
    }

    public Date getFechaFinMundoRol() {
        return fechaFinMundoRol;
    }

    public void setFechaFinMundoRol(Date fechaFinMundoRol) {
        this.fechaFinMundoRol = fechaFinMundoRol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
