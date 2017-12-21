/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.messaging;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "PremioPregunta")
public class PremioPregunta {

    public enum TipoConsigna {
        MULTIPLE_CHOICE, TEXTO, NOSE
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pp;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String consigna;

    @Column(nullable = false)
    private boolean disparada;

    /**
     * @return Tiempo que tiene el personaje para contestar la pregunta apenas la abre. si el tiempo es -1 entonces no hay tiempo
     */
    @Column(nullable = false)
    private int timeResponse;

    /**
     * @return define cuantos de los primeros personajes en contestar seràn ganadores, al completar el nùmero, el resto ya no tendrà premio
     */
    @Column(nullable = false)
    private int cantGanadores;

    /**
     * @return Si està en True, los personajes que respondan, deberàn esperar a que todos hayan contestado, para saber si respondieron adecuadamente.
     */
    @Column(nullable = false)
    private boolean waitForAll;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Premio> premio;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<OpcionPremioPregunta> opciones;
    
    public int getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(int timeResponse) {
        this.timeResponse = timeResponse;
    }

    public int getCantGanadores() {
        return cantGanadores;
    }

    public void setCantGanadores(int cantGanadores) {
        this.cantGanadores = cantGanadores;
    }

    public boolean isWaitForAll() {
        return waitForAll;
    }

    public void setWaitForAll(boolean waitForAll) {
        this.waitForAll = waitForAll;
    }

    

    @OneToMany
    Set<OpcionPremioPregunta> choices;

    public PremioPregunta() {
        disparada = false;
    }

    public long getId_pp() {
        return id_pp;
    }

    public void setId_pp(long id_pp) {
        this.id_pp = id_pp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsigna() {
        return consigna;
    }

    public void setConsigna(String consigna) {
        this.consigna = consigna;
    }

    public boolean isDisparada() {
        return disparada;
    }

    public void setDisparada(boolean disparada) {
        this.disparada = disparada;
    }

    public Set<OpcionPremioPregunta> getChoices() {
        return choices;
    }

    public void setChoices(Set<OpcionPremioPregunta> choices) {
        this.choices = choices;
    }

    public Set<Premio> getPremio() {
        return premio;
    }

    public void setPremio(Set<Premio> premio) {
        this.premio = premio;
    }

    public Set<OpcionPremioPregunta> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<OpcionPremioPregunta> opciones) {
        this.opciones = opciones;
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
        final PremioPregunta other = (PremioPregunta) obj;
        if (this.id_pp != other.id_pp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PremioPregunta{" + "id_pp=" + id_pp + ", fecha=" + fecha + ", titulo=" + titulo + ", consigna=" + consigna + ", disparada=" + disparada + ", timeResponse=" + timeResponse + ", cantGanadores=" + cantGanadores + ", waitForAll=" + waitForAll + ", premio=" + premio + ", opciones=" + opciones + ", choices=" + choices + '}';
    }

    
}
