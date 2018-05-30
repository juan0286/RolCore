/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.pj;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Efecto")
public class Efecto {

    public static enum EstadoEfecto {
        ACTIVO, INATIVO, ANULADO,FINALIZADO
    }
    
    public static enum ClaseEfecto {
        MAGICO, FISICO
    }
    public static enum ReinoMagicoEfecto {
        CANALIZACION, ESCENCIA, MENTALISMO, ARCANO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_efecto;

    
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)  
    private Set<Modifier> mods;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)  
    private Set<ModFisico> modFisicos;

    @Column
    private boolean anulacion_progresiva;

    @Column
    private long tiempoRegeneracion;
    
    @Column
    private String descripcion;
    
    @Column
    private ClaseEfecto clase;
    
    @Column
    private ReinoMagicoEfecto reinoMagico;
    
    public Efecto() {
    }

    public long getId_herida() {
        return id_efecto;
    }

    public void setId_herida(long id_herida) {
        this.id_efecto = id_herida;
    }

    public Set<Modifier> getMods() {
        return mods;
    }

    public void setMods(Set<Modifier> mods) {
        this.mods = mods;
    }

    public Set<ModFisico> getModFisicos() {
        return modFisicos;
    }

    public void setModFisicos(Set<ModFisico> modFisicos) {
        this.modFisicos = modFisicos;
    }

    public boolean isAnulacion_progresiva() {
        return anulacion_progresiva;
    }

    public void setAnulacion_progresiva(boolean anulacion_progresiva) {
        this.anulacion_progresiva = anulacion_progresiva;
    }

    public long getTiempoRegeneracion() {
        return tiempoRegeneracion;
    }

    public void setTiempoRegeneracion(long tiempoRegeneracion) {
        this.tiempoRegeneracion = tiempoRegeneracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId_efecto() {
        return id_efecto;
    }

    public void setId_efecto(long id_efecto) {
        this.id_efecto = id_efecto;
    }

    public ClaseEfecto getClase() {
        return clase;
    }

    public void setClase(ClaseEfecto clase) {
        this.clase = clase;
    }

    public ReinoMagicoEfecto getReinoMagico() {
        return reinoMagico;
    }

    public void setReinoMagico(ReinoMagicoEfecto reinoMagico) {
        this.reinoMagico = reinoMagico;
    }

     public void addMod(Modifier m) {
        if (mods == null) {
            mods = new HashSet<Modifier>();
        }
        mods.add(m);
    }

    public void addModFisico(ModFisico mf) {
        if (modFisicos == null) {
            modFisicos = new HashSet<ModFisico>();
        }
        modFisicos.add(mf);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Efecto other = (Efecto) obj;
        if (this.id_efecto != other.id_efecto) {
            return false;
        }
        return true;
    }

    
    
}
