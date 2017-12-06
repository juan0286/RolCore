/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.messaging;

import com.websystique.spring.model.Personaje;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "RespuestaPremioPregunta")
public class RespuestaPremioPregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rpp;
    
    @ManyToOne
    private Personaje personaje;
    
    @ManyToOne
    private PremioPregunta premioPregunta;

    @ManyToOne
    private OpcionPremioPregunta opcionPremioPregunta;

    @Column(nullable = false)
    private Date fecha;

    public RespuestaPremioPregunta() {
    }

    public long getId_rpp() {
        return id_rpp;
    }

    public void setId_rpp(long id_rpp) {
        this.id_rpp = id_rpp;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public PremioPregunta getPremioPregunta() {
        return premioPregunta;
    }

    public void setPremioPregunta(PremioPregunta premioPregunta) {
        this.premioPregunta = premioPregunta;
    }

    public OpcionPremioPregunta getOpcionPremioPregunta() {
        return opcionPremioPregunta;
    }

    public void setOpcionPremioPregunta(OpcionPremioPregunta opcionPremioPregunta) {
        this.opcionPremioPregunta = opcionPremioPregunta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        final RespuestaPremioPregunta other = (RespuestaPremioPregunta) obj;
        if (this.id_rpp != other.id_rpp) {
            return false;
        }
        return true;
    }
    
    
    
    
}
