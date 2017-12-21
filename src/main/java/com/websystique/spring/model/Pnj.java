/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model;

import com.websystique.spring.model.caractPj.Caracteristicas;
import com.websystique.spring.model.caractPj.Habilidades;
import java.io.Serializable;
import java.util.HashSet;
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

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Pnj")
public class Pnj implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pnj;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private int nivel;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})     
    private Set<Info> informacion;    
    
    @Column(nullable = false)
    private String raza;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Profesion profesion;
    
    @Column(nullable = false)
    private int altura;
        
    @Column(nullable = false)
    private String genero;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    @JoinColumn(name = "ID_HABIL")
    private Habilidades habilidades;
    
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
    @JoinColumn(name = "ID_CARACT")
    private Caracteristicas caracteristicas;   

    
    public Pnj() {
    }

    
    
    public long getId_pnj() {
        return id_pnj;
    }

    public void setId_pnj(long id_pnj) {
        this.id_pnj = id_pnj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Set<Info> getInformacion() {
        return informacion;
    }

    public void setInformacion(Set<Info> informacion) {
        this.informacion = informacion;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
    
    public void addInfo(Info i){
        if (informacion == null)
            informacion =  new HashSet<Info>();
        informacion.add(i);
    }
    
    public void addInfo(boolean soloMaster,String texto, String titulo){
        if (informacion == null)
            informacion =  new HashSet<Info>();
        
        Info i = new Info();
        i.setSoloMaster(true);
        i.setTexto(texto);
        i.setTitulo(titulo);
        
        informacion.add(i);
    }
}
