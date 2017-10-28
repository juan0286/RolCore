/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.caractPj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Habilidades")
@XmlRootElement
public class Habilidades implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_habilidades;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Hab_armadura habArmadura;
     
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Hab_armas habArmas;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Hab_generales habGenerales;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Hab_subterfugio habSubterfugio;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Hab_magicas habMagicas;
    
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Hab_secundaria_desarrollo> habSecundarias = new ArrayList<Hab_secundaria_desarrollo>();;
    
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Idioma_desarrollo> idiomas = new ArrayList<Idioma_desarrollo>();
    
    @Column(nullable = false)
    private int desarrolloFisico;
    
    @Column(nullable = false)
    private int percepcion;
    
    @Column(nullable = false)
    private int puntosPoder;
    
    @Column(nullable = false)
    private int liderazgoInfluencia;
    
    @Column(nullable = false)
    private int bonificacionDefensiva;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    private Resistencias resistencias; 
    
    // private listasDeSortilegios
    // private sortilegios

    public Habilidades() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Habilidades other = (Habilidades) obj;
        if (this.id_habilidades != other.id_habilidades) {
            return false;
        }
        return true;
    }
    
    public void aprenderIdioma(Idioma_desarrollo i){
        idiomas.add(i);
    }

    public void aprenderHabiSec(Hab_secundaria_desarrollo h){
        habSecundarias.add(h);
    }
     
    public long getId_habilidades() {
        return id_habilidades;
    }

    public void setId_habilidades(long id_habilidades) {
        this.id_habilidades = id_habilidades;
    }

    public Hab_armadura getHabArmadura() {
        return habArmadura;
    }

    public void setHabArmadura(Hab_armadura habArmadura) {
        this.habArmadura = habArmadura;
    }

    public Hab_armas getHabArmas() {
        return habArmas;
    }

    public void setHabArmas(Hab_armas habArmas) {
        this.habArmas = habArmas;
    }

    public Hab_generales getHabGenerales() {
        return habGenerales;
    }

    public void setHabGenerales(Hab_generales habGenerales) {
        this.habGenerales = habGenerales;
    }

    public Hab_subterfugio getHabSubterfugio() {
        return habSubterfugio;
    }

    public void setHabSubterfugio(Hab_subterfugio habSubterfugio) {
        this.habSubterfugio = habSubterfugio;
    }

    public Hab_magicas getHabMagicas() {
        return habMagicas;
    }

    public void setHabMagicas(Hab_magicas habMagicas) {
        this.habMagicas = habMagicas;
    }

    @XmlTransient
    public List<Hab_secundaria_desarrollo> getHabSecundarias() {
        return habSecundarias;
    }

    public void setHabSecundarias(List<Hab_secundaria_desarrollo> habSecundarias) {
        this.habSecundarias = habSecundarias;
    }

    @XmlTransient
    public List<Idioma_desarrollo> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma_desarrollo> idiomas) {
        this.idiomas = idiomas;
    }

    public int getDesarrolloFisico() {
        return desarrolloFisico;
    }

    public void setDesarrolloFisico(int desarrolloFisico) {
        this.desarrolloFisico = desarrolloFisico;
    }

    public int getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

    public int getPuntosPoder() {
        return puntosPoder;
    }

    public void setPuntosPoder(int puntosPoder) {
        this.puntosPoder = puntosPoder;
    }

    public int getLiderazgoInfluencia() {
        return liderazgoInfluencia;
    }

    public void setLiderazgoInfluencia(int liderazgoInfluencia) {
        this.liderazgoInfluencia = liderazgoInfluencia;
    }

    public int getBonificacionDefensiva() {
        return bonificacionDefensiva;
    }

    public void setBonificacionDefensiva(int bonificacionDefensiva) {
        this.bonificacionDefensiva = bonificacionDefensiva;
    }

    public Resistencias getResistencias() {
        return resistencias;
    }

    public void setResistencias(Resistencias resistencias) {
        this.resistencias = resistencias;
    }

    @Override
    public String toString() {
        return habArmadura + "\n" + 
                habArmas + "\n" + 
                habGenerales + "\n" + 
                habSubterfugio + "\n" + 
                habMagicas + "\n" + "habSecundarias=\n" + 
                habSecundarias + "\n" + "idiomas=" + 
                idiomas + "\n" + "desarrolloFisico=" + 
                desarrolloFisico + "\n" + "percepcion=" + 
                percepcion + "\n" + "puntosPoder=" + 
                puntosPoder + "\n" + "liderazgoInfluencia=" + 
                liderazgoInfluencia + "\n" + "bonificacionDefensiva=" + 
                bonificacionDefensiva + "\n" + 
                resistencias + '}';
    }
    
    
    
}
