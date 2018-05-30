/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.model.pj;

import com.websystique.spring.model.Personaje;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author TiranoJuan
 */
@Entity
@Table(name = "Modifier")
public class Modifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mod;

    //@Enumerated(EnumType.STRING)
    @Column
    private Operador operador;
            
    //@Enumerated(EnumType.STRING)
    @Column
    private Propiedad propiedad;

    @Column
    private float factor;
    
    
    public Modifier() {
    }

    public long getId_mod() {
        return id_mod;
    }

    public void setId_mod(long id_mod) {
        this.id_mod = id_mod;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
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
        final Modifier other = (Modifier) obj;
        if (this.id_mod != other.id_mod) {
            return false;
        }
        return true;
    }

    
    
    



  public static enum Operador {
        SUMA, RESTA, DIVISION, MULTIPLE
    };

    
    public static enum Propiedad {
        SA,
        C,
        CE,
        CM,
        CO,
        AGI,
        CON,
        INTE,
        I,
        PRE,
        APA,
        CONTUNDENTES,
        DOSMANOS,
        ARROJADIZAS,
        PROYECTILES,
        ASTA,
        PELEA,
        TREPAR,
        MONTAR,
        NADAR,
        RASTREAR,
        LEERRUNAS,
        USAROBJETOS,
        SORTILEGIOSDIRGIDOS,
        SORTILEGIOSBASE,
        EMBOSCAR,
        ACECHARESCONDERSE,
        ABRIRCERRADURAS,
        DESACTIVARTRAMPAS,
        PERCEPCION,
        PUNTOS_VIDA,
        PUNTOS_PODER,
        BO,
        BD,
        MM,
        PUNTOSDANIO_HECHOS,
        PUNTOSDANIO_RECIBIDOS,
        ACTIVIDAD,
        STAMINA,
        HIDRATACION,
        NUTRICION,
        HABLAR,
        ESCUCHAR,
        VER,
        OLER
    }
}

 /*
        TIPO_QUEMADURA,
        TIPO_CONGELAMIENTO,
        TIPO_SANGRADO,
        TIPO_OBLIGADO_A_PARAR,
        TIPO_ATURDIDO,
        TIPO_ATURDIDO_SIN_PARAR,
        TIPO_RESTAR_PV_TOTAL,
        TIPO_DIVIDIR_PV_TOTAL,
        TIPO_DORMIDO,
        TIPO_DIVIDE_LA_ACTIVIDAD,        
        TIPO_CIERRA_SANGRADO,
        TIPO_DESATURDIR,
        TIPO_SUMAR_PV,
        TIPO_MULTIPLICAR_PV,
        TIPO_SUMAR_PP,
        TIPO_MULTIPLICAR_PP,
        TIPO_MULTIPLICAR_PV_DAÑO,
        TIPO_DIVIDIR_PV_DAÑO,        
        TIPOS_UNO_A_UNO,        
        TIPO_AUMENTA_ACTIVIDAD,
        TIPO_AUMENTO_DE_MM,
        TIPO_AUMENTO_DE_TR,
        TIPO_AUMENTO_DE_BO,
        TIPO_AUMENTO_DE_BO_FILO,
        TIPO_AUMENTO_DE_BO_CONTUNDENTE,
        TIPO_AUMENTO_DE_BO_DOS_MANOS,
        TIPO_AUMENTO_DE_BO_PROYECTILES,
        TIPO_AUMENTO_DE_BO_ASTA,
        TIPO_AUMENTO_DE_BO_ATAQUE_DRAGON,
        TIPO_AUMENTO_DE_BD,        
        TIPO_RESTA_DE_ACTIVIDAD,
        TIPO_RESTA_DE_MM,
        TIPO_RESTA_DE_BO,
        TIPO_RESTA_DE_BD,
        TIPO_RESTA_DE_TR,
        TIPO_RESTA_DE_RESISTENCIA_CALOR,
        TIPO_RESTA_DE_RESISTENCIA_FRIO,
        TIPO_RESTA_DE_RESISTENCIA_ESCENCIA,
        TIPO_RESTA_DE_RESISTENCIA_CANALIZACION,
        TIPO_RESTA_DE_RESISTENCIA_MENTALISMO,        
        TIPOS_CINCO_A_CINCO,        
        TIPO_LEVANTARSE,
        TIPO_POSTRADO,
        TIPO_DERRIBADO,        
        TIPOS_SOLO_UNO,        
        TIPO_DESACTIVAR_EXTREMIDAD,
        TIPO_ACTIVAR_EXTREMIDAD,
        TIPO_ACEL_CURA_EXTREMIDAD                
    }
     */