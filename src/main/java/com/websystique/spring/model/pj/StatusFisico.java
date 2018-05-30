/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.pj;

import com.websystique.spring.Constantes.Stamina;
import com.websystique.spring.model.Personaje;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "StatusFisico")
public class StatusFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sf;

    @OneToOne
    Personaje pj;

    // stamina cansancio
    @Column
    private int staminaFinal;

    @Column
    private int staminaActual;

    @Column
    private int stm_perdPorHora;
    @Column
    private int stm_recPorHoraDurmiendo;
    @Column
    private int stm_recPorHoraDescanso;
    @Column
    private int stm_penalizacionAct;

    // stamina nutricion
    @Column
    private int nutricionFinal;
    @Column
    private int nutricionActual;
    @Column
    private int nut_perdPorHora;
    @Column
    private int nut_penalizacionAct;

    // stamina hidratacion
    @Column
    private int hidratacionFinal;
    @Column
    private int hidratacionActual;
    @Column
    private int hid_perdPorHora;
    @Column
    private int hid_penalizacionAct;

    // puntos perdidos
    @Column
    private int pv_perdidos;
    @Column
    private int pp_perdidos;
    @Column
    private int pv_sangre_perdidos;  //     Estos son puntos de sangre ya perdidos, y no heridas abierta sangrando actualmente.

    // asatos aturdido
    @Column
    private int asaltos_obligado_a_Parar;
    @Column
    private int asaltos_aturdido;
    @Column
    private int asaltos_aturdido_sin_poder_parar;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Herida> heridas;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Efecto> efectos;

    public StatusFisico() {
    }

    public StatusFisico(Personaje pj) {

        this.pj = pj;
        int horasSueño = pj.getHorasDeSueño();
        int con = pj.getCaracteristicas().getCon();

        staminaFinal = Stamina.STAMINA_BASICA + con * 10;
        staminaActual = Stamina.STAMINA_BASICA;

        stm_perdPorHora = staminaFinal / 2 / (24 - horasSueño);
        stm_recPorHoraDurmiendo = staminaFinal / 2 / horasSueño;
        stm_recPorHoraDescanso = staminaFinal / 4 / horasSueño;;
        stm_penalizacionAct = 0;

        nutricionFinal = Stamina.NUTRICION_BASICA + (con * 10);
        nutricionActual = Stamina.NUTRICION_BASICA;
        nut_perdPorHora = Stamina.NUTRICION_BASICA / 2 / 24;
        nut_penalizacionAct = 0;

        hidratacionFinal = Stamina.HIDRATACION_BASICA + (con * 10);
        hidratacionActual = Stamina.HIDRATACION_BASICA;
        hid_perdPorHora = Stamina.HIDRATACION_BASICA / 1 / 24;

        hid_penalizacionAct = 0;
        pv_perdidos = 0;
        pv_sangre_perdidos = 0;
        pp_perdidos = 0;
        asaltos_obligado_a_Parar = 0;
        asaltos_aturdido = 0;
        asaltos_aturdido_sin_poder_parar = 0;

    }

    public long getId_sf() {
        return id_sf;
    }

    public void setId_sf(long id_sf) {
        this.id_sf = id_sf;
    }

    public Personaje getPj() {
        return pj;
    }

    public void setPj(Personaje pj) {
        this.pj = pj;
    }

    public int getStaminaFinal() {
        return staminaFinal;
    }

    public void setStaminaFinal(int staminaFinal) {
        this.staminaFinal = staminaFinal;
    }

    public int getStaminaActual() {
        return staminaActual;
    }

    public void setStaminaActual(int staminaActual) {
        this.staminaActual = staminaActual;
    }

    public int getStm_perdPorHora() {
        return stm_perdPorHora;
    }

    public void setStm_perdPorHora(int stm_perdPorHora) {
        this.stm_perdPorHora = stm_perdPorHora;
    }

    public int getStm_recPorHoraDurmiendo() {
        return stm_recPorHoraDurmiendo;
    }

    public void setStm_recPorHoraDurmiendo(int stm_recPorHoraDurmiendo) {
        this.stm_recPorHoraDurmiendo = stm_recPorHoraDurmiendo;
    }

    public int getStm_recPorHoraDescanso() {
        return stm_recPorHoraDescanso;
    }

    public void setStm_recPorHoraDescanso(int stm_recPorHoraDescanso) {
        this.stm_recPorHoraDescanso = stm_recPorHoraDescanso;
    }

    public int getStm_penalizacionAct() {
        return stm_penalizacionAct;
    }

    public void setStm_penalizacionAct(int stm_penalizacionAct) {
        this.stm_penalizacionAct = stm_penalizacionAct;
    }

    public int getNutricionFinal() {
        return nutricionFinal;
    }

    public void setNutricionFinal(int nutricionFinal) {
        this.nutricionFinal = nutricionFinal;
    }

    public int getNutricionActual() {
        return nutricionActual;
    }

    public void setNutricionActual(int nutricionActual) {
        this.nutricionActual = nutricionActual;
    }

    public int getNut_perdPorHora() {
        return nut_perdPorHora;
    }

    public void setNut_perdPorHora(int nut_perdPorHora) {
        this.nut_perdPorHora = nut_perdPorHora;
    }

    public int getNut_penalizacionAct() {
        return nut_penalizacionAct;
    }

    public void setNut_penalizacionAct(int nut_penalizacionAct) {
        this.nut_penalizacionAct = nut_penalizacionAct;
    }

    public int getHidratacionFinal() {
        return hidratacionFinal;
    }

    public void setHidratacionFinal(int hidratacionFinal) {
        this.hidratacionFinal = hidratacionFinal;
    }

    public int getHidratacionActual() {
        return hidratacionActual;
    }

    public void setHidratacionActual(int hidratacionActual) {
        this.hidratacionActual = hidratacionActual;
    }

    public int getHid_perdPorHora() {
        return hid_perdPorHora;
    }

    public void setHid_perdPorHora(int hid_perdPorHora) {
        this.hid_perdPorHora = hid_perdPorHora;
    }

    public int getHid_penalizacionAct() {
        return hid_penalizacionAct;
    }

    public void setHid_penalizacionAct(int hid_penalizacionAct) {
        this.hid_penalizacionAct = hid_penalizacionAct;
    }

    public int getPv_perdidos() {
        return pv_perdidos;
    }

    public void setPv_perdidos(int pv_perdidos) {
        this.pv_perdidos = pv_perdidos;
    }

    public int getPv_sangre_perdidos() {
        return pv_sangre_perdidos;
    }

    public void setPv_sangre_perdidos(int pv_sangre_perdidos) {
        this.pv_sangre_perdidos = pv_sangre_perdidos;
    }

    public int getPp_perdidos() {
        return pp_perdidos;
    }

    public void setPp_perdidos(int pp_perdidos) {
        this.pp_perdidos = pp_perdidos;
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

    public Set<Herida> getHeridas() {
        return heridas;
    }

    public void setHeridas(Set<Herida> heridas) {
        this.heridas = heridas;
    }

    public Set<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfectos(Set<Efecto> efectos) {
        this.efectos = efectos;
    }

    public void addHerida(Herida h) {
        if (heridas == null) {
            heridas = new HashSet<Herida>();
        }
        heridas.add(h);
    }
    
    public void addEfecto(Efecto e) {
        if (efectos == null) {
            efectos = new HashSet<Efecto>();
        }
        efectos.add(e);
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
        final StatusFisico other = (StatusFisico) obj;
        if (this.id_sf != other.id_sf) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StatusFisico{" + "id_sf=" + id_sf + ", pj=" + pj.getNombre() + '}';
    }

}
