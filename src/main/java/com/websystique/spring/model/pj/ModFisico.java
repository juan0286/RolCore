/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.pj;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "ModFisico")
public class ModFisico {

    public static enum HitFisico {NINGUNO,
        CIEGO, SORDO, MURDO, ANOSMICO,
        PARALISIS_COMPLETA, PARALISIS_MITAD,
        BRAZO_DERECHO_INUTIL, BRAZO_IZQUIERDO_INUTIL,
        PIERNA_DERECHO_INUTIL, PIERNA_IZQUIERA_INUTIL, PIERDE_NARIZ, PIERDE_OREJA_IZQUIERDA,PIERDE_OREJA_DERECHA
    }

    public static enum HitMental {NINGUNO,
        DORMIDO,
        INCONSCIENTE, COMA,
        MUERTE_CEREBRAL
    }

    public static enum Gravedad {
        LEVE, NORMAL, GRAVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_modFisico;

    @Enumerated(EnumType.STRING)
    private HitFisico hitFisico;

    @Enumerated(EnumType.STRING)
    private HitMental hitMental;

    public long getId_modFisico() {
        return id_modFisico;
    }

    public void setId_modFisico(long id_modFisico) {
        this.id_modFisico = id_modFisico;
    }

    public HitFisico getHitFisico() {
        return hitFisico;
    }

    public void setHitFisico(HitFisico hitFisico) {
        this.hitFisico = hitFisico;
    }

    public HitMental getHitMental() {
        return hitMental;
    }

    public void setHitMental(HitMental hitMental) {
        this.hitMental = hitMental;
    }

    public ModFisico() {
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
        final ModFisico other = (ModFisico) obj;
        if (this.id_modFisico != other.id_modFisico) {
            return false;
        }
        return true;
    }
    
    
    

}
