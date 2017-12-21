/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import com.websystique.spring.model.bono.Bono;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.caractPj.Caracteristicas;
import com.websystique.spring.model.caractPj.Habilidades;
import com.websystique.spring.model.caractPj.Idioma_desarrollo;
import com.websystique.spring.model.objetos.BolsaDeMonedas;
import com.websystique.spring.model.objetos.CajaObjetos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Personaje")
@XmlRootElement
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pj;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    private Jugador jugador;
    //private Profesion profesion;

    @Column(nullable = false)
    private int exp;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private String raza;

    @Column(nullable = false)
    private int altura;

    @Column(nullable = false)
    private int peso;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private int edad;

    @Column
    private String motivacion;

    @Column(nullable = false)
    private String alineamiento;

    @Column
    private String estado_civico;

    @Column
    private String familia;

    @Column
    private String diosesAdorados;

    @Column
    private String religion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "ID_HABIL")
    private Habilidades habilidades;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "ID_CARACT")
    private Caracteristicas caracteristicas;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    List<BonoExp> bonosExp = new ArrayList<BonoExp>();

    @ManyToOne
    Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

//    private mod_caract m_c;
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
//    private set<Lista> listas;
//    private set<sortilegio> sortilegios; 
    @OneToOne(cascade = CascadeType.ALL)
    private CajaObjetos cajaObjetos;

    @OneToOne(cascade = CascadeType.ALL)
    private CajaObjetos cargaCaballos;

    @OneToOne(cascade = CascadeType.ALL)
    private BolsaDeMonedas bolsaDeMonedas;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Bono> bonos;

    public Personaje() {
    }

    public void aplicarBonoExp(BonoExp be) {
        bonosExp.add(be);
    }

    public long getId_pj() {
        return id_pj;
    }

    public void setId_pj(long id_pj) {

        this.id_pj = id_pj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

//    public Profesion getProfesion() {
//        return profesion;
//    }
//
//    public void setProfesion(Profesion profesion) {
//        this.profesion = profesion;
//    }
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public CajaObjetos getCajaObjetos() {
        return cajaObjetos;
    }

    public void setCajaObjetos(CajaObjetos cajaObjetos) {
        this.cajaObjetos = cajaObjetos;
    }

    public CajaObjetos getCargaCaballos() {
        return cargaCaballos;
    }

    public void setCargaCaballos(CajaObjetos cargaCaballos) {
        this.cargaCaballos = cargaCaballos;
    }

    public BolsaDeMonedas getBolsaDeMonedas() {
        return bolsaDeMonedas;
    }

    public void setBolsaDeMonedas(BolsaDeMonedas bolsaDeMonedas) {
        this.bolsaDeMonedas = bolsaDeMonedas;
    }

    public Set<Bono> getBonos() {
        return bonos;
    }

    public void setBonos(Set<Bono> bonos) {
        this.bonos = bonos;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }

    public String getAlineamiento() {
        return alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    public String getEstado_civico() {
        return estado_civico;
    }

    public void setEstado_civico(String estado_civico) {
        this.estado_civico = estado_civico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getDiosesAdorados() {
        return diosesAdorados;
    }

    public void setDiosesAdorados(String diosesAdorados) {
        this.diosesAdorados = diosesAdorados;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Habilidades getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidades habilidades) {
        this.habilidades = habilidades;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<BonoExp> getBonosExp() {
        return bonosExp;
    }

    public void setBonosExp(List<BonoExp> bonosExp) {
        this.bonosExp = bonosExp;
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
        final Personaje other = (Personaje) obj;
        if (this.id_pj != other.id_pj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String toFullString() {
        return "Personaje{" + "id_pj=" + id_pj + "\n" + "nombre=" + nombre + "\n"
                + "exp=" + exp + "\n"
                + "nivel=" + nivel + "\n"
                + "raza=" + raza + "\n"
                + "altura=" + altura + "\n"
                + "peso=" + peso + "\n"
                + "genero=" + genero + "\n"
                + "edad=" + edad + "\n"
                + "motivacion=" + motivacion + "\n"
                + "alineamiento=" + alineamiento + "\n"
                + "estado_civico=" + estado_civico + "\n"
                + "familia=" + familia + "\n"
                + "diosesAdorados=" + diosesAdorados + "\n"
                + "religion=" + religion + "\n"
                + "caracteristicas=" + caracteristicas + "\n"
                + "habilidades=" + habilidades;
    }

}
