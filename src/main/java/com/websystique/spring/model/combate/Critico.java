/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.combate;

import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.pj.Modifier;
import com.websystique.spring.model.pj.ModFisico;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Critico")
@XmlRootElement
public class Critico implements Serializable{
    
    public static enum Tabla {
        CORTE,APLASTAMIENTO,
        PERFORACION,PELEA,ARTES_MARCIALES,
        BARRIDO_AM,
        ANIMALES_PEQUEÑOS,GRANDES_CRIATURAS, 
        SUPER_GRANDES_CRIATURAS
    }
    
    @EmbeddedId    
    private CodeCritico id_critico;
            
    @Column
    private String descripcion;
    
    @Column
    private int pv;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ModFisico> modsFisicos;    
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Modifier> mods;    
    
    @Column
    private int perdidaPv;
    
    @Column
    private int asaltosYMuere;    
    
    @Column        
    private int bonoGolpeSiguiente;    

    @Column
    private int asaltos_obligado_a_Parar;
    
    @Column
    private int asaltos_aturdido;
    
    @Column
    private int asaltos_aturdido_sin_poder_parar;
    
    @Column
    private int restoActividad;

    public Critico() {
    }

    public CodeCritico getId() {
        return id_critico;
    }

    public void setId(CodeCritico id) {
        this.id_critico = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
 

    public Set<ModFisico> getModsFisicos() {
        return modsFisicos;
    }

    public void setModsFisicos(Set<ModFisico> modsFisicos) {
        this.modsFisicos = modsFisicos;
    }

    public int getPerdidaPv() {
        return perdidaPv;
    }

    public void setPerdidaPv(int perdidaPv) {
        this.perdidaPv = perdidaPv;
    }

    public int getAsaltosYMuere() {
        return asaltosYMuere;
    }

    public void setAsaltosYMuere(int asaltosYMuere) {
        this.asaltosYMuere = asaltosYMuere;
    }

    public void addcMod(Modifier m){
        if (this.mods == null){
            this.mods = new HashSet<Modifier>();
        } 
        this.mods.add(m);
    }
    
    public void addcModFisico(ModFisico m){
        if (this.modsFisicos == null){
            this.modsFisicos = new HashSet<ModFisico>();
        } 
        this.modsFisicos.add(m);         
    }

    public int getBonoGolpeSiguiente() {
        return bonoGolpeSiguiente;
    }

    public void setBonoGolpeSiguiente(int bonoGolpeSiguiente) {
        this.bonoGolpeSiguiente = bonoGolpeSiguiente;
    }

    public Set<Modifier> getMods() {
        return mods;
    }

    public void setMods(Set<Modifier> mods) {
        this.mods = mods;
    }       
    
    public int getAsaltos_obligado_a_Parar() {
        return asaltos_obligado_a_Parar;
    }

    public void setAsaltos_obligado_a_Parar(int asaltos_obligado_a_Parar) {
        this.asaltos_obligado_a_Parar = asaltos_obligado_a_Parar;
    }

    public int getAsaltos_aturdido() {
        return asaltos_aturdido;
    }

    public void setAsaltos_aturdido(int asaltos_aturdido) {
        this.asaltos_aturdido = asaltos_aturdido;
    }

    public int getAsaltos_aturdido_sin_poder_parar() {
        return asaltos_aturdido_sin_poder_parar;
    }

    public void setAsaltos_aturdido_sin_poder_parar(int asaltos_aturdido_sin_poder_parar) {
        this.asaltos_aturdido_sin_poder_parar = asaltos_aturdido_sin_poder_parar;
    }

    public CodeCritico getId_critico() {
        return id_critico;
    }

    public void setId_critico(CodeCritico id_critico) {
        this.id_critico = id_critico;
    }

    public int getRestoActividad() {
        return restoActividad;
    }

    public void setRestoActividad(int restoActividad) {
        this.restoActividad = restoActividad;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id_critico != null ? this.id_critico.hashCode() : 0);
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
        final Critico other = (Critico) obj;
        if (this.id_critico != other.id_critico && (this.id_critico == null || !this.id_critico.equals(other.id_critico))) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Critico{" + id_critico + ", desc=" + descripcion + '}';
    }
    
    
    
}
