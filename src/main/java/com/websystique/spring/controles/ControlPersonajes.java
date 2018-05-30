/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.controles;

import com.websystique.spring.Constantes;
import com.websystique.spring.HibernateDao;
import com.websystique.spring.Recursos;
import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.model.combate.Damage;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.Tempo;
import com.websystique.spring.model.pj.Efecto;
import com.websystique.spring.model.pj.Herida;
import com.websystique.spring.model.pj.ModFisico;
import com.websystique.spring.model.pj.Modifier;
import static java.lang.Math.toIntExact;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

/**
 *
 * @author TiranoJuan
 */
public class ControlPersonajes {

    /*
    dañar
    curar
    sanar (con el tiempo)
    alimentar
    hidratar
    descansar
    
    
    ADHESIONES
    A/Q ojetos (peso penalizacion por carga)
    A/Q dinero  (peso penalizacion por carga)
    A/Q Habilidades Secundarias
    A/Q Modificadores  (de todo, penalizaciones, bonos etc)
    A/Q poderes especiales 
    A/Q familiares (caja de objetos extra)
    A/Q Vales (vale por no morir, cosas asi)
    
    COLOCAR / QUITAR armadura u objeto, arma, puede quitar o dar un modificador
    
     */
    public static boolean hitPj(Damage d, Personaje pj) {

        boolean ret = false;
        pj.perderPv(d.getPv());
        Critico c = d.getCritico();
        if (c != null) {

            Herida h = new Herida();
            h.setEstadoHerida(Herida.EstadoHerida.ACTIVA);
            h.setPj(pj);
            h.setDescripcion(c.getDescripcion());
            h.setGravedad(Herida.GravedadHerida.GRAVE);
            h.setLocacionHerida(Herida.LocacionHerida.CABEZA);
            h.setRestoActividad(0);
            
            if (c.getMods() != null) {
                for (Modifier m : c.getMods()) {
                    Modifier m1 = new Modifier();
                    m1.setFactor(m.getFactor());
                    m1.setOperador(m.getOperador());
                    m1.setPropiedad(m.getPropiedad());
                    h.addMod(m1);
                }
            }
            if (c.getModsFisicos() != null) {
                for (ModFisico m : c.getModsFisicos()) {
                    ModFisico m1 = new ModFisico();
                    m1.setHitFisico(m.getHitFisico());
                    m1.setHitMental(m.getHitMental());
                    h.addModFisico(m1);
                }
            }
//            if (c.getRestoActividad() != 0) {
//                Modifier m1 = new Modifier();
//                m1.setFactor(c.getRestoActividad());
//                m1.setOperador(Modifier.Operador.RESTA);
//                m1.setPropiedad(Modifier.Propiedad.ACTIVIDAD);
//                h.addMod(m1);
//            }

            h.setAnulacion_progresiva(true);

            h.setTipoHerida(Herida.TipoHerida.MUSCULAR);

            h.setPvAsalto(0);

            h.setRestoActividad(c.getRestoActividad());
     
            Tempo t = new Tempo();
            t.setCampaign(pj.getCampaign());
            t.setInicio(new Date());
            long cad = Recursos.tiempoEnAsaltosParse(5, Constantes.TIEMPO.TIEMPO_DIAS);
            t.setCaducidad(cad);
            t.setTranscurso((Recursos.aleatorioEntre(0, toIntExact(cad))));
            
            h.setTempo(t);
            // Giardar la Herida
            HibernateDao.crearHerida(h);
            pj.herir(h);
            ret = HibernateDao.actualizarPersonaje(pj);

        }
        return ret;
    }

    public static void anularHeridaPj(Herida h) {
        h.setEstadoHerida(Herida.EstadoHerida.ANULADA);
        HibernateDao.actualizarHerida(h);
    }

    public static void curarHeridaPj(Herida h) {
        h.setEstadoHerida(Herida.EstadoHerida.CURADA);
        HibernateDao.actualizarHerida(h);
    }
    
    public static void borrarHeridaPj(Personaje p, Herida h) {        
        p.getStatusFisico().getHeridas().remove(h);
        HibernateDao.actualizarPersonaje(p);
        boolean borrarHerida = HibernateDao.borrarHerida(h);
    }

    
    //   Escribir aplicar Efectos al Personaje
    
    public static void afectarAlPj(Personaje pj, Efecto e) {

        // Set<Herida> heridas = pj.getStatusFisico().getHeridas();
        Set<Herida> heridas = null;
        for (Herida herida : heridas) {

        }

    }
    
    
    public static void actividadActualdePj(Personaje pj) {

        // Set<Herida> heridas = pj.getStatusFisico().getHeridas();
        Set<Herida> heridas = null;
        for (Herida herida : heridas) {

        }

    }

}
