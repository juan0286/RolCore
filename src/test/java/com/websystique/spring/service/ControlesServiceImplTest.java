/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.websystique.spring.Constantes;
import com.websystique.spring.Constantes.TIEMPO;
import com.websystique.spring.HibernateDao;
import com.websystique.spring.Recursos;
import com.websystique.spring.controles.ControlCampaign;
import com.websystique.spring.controles.ControlPersonajes;
import com.websystique.spring.dao.ControlesDaoImpl;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.Tempo;
import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.model.combate.Damage;
import com.websystique.spring.model.pj.Efecto;
import com.websystique.spring.model.pj.Herida;
import com.websystique.spring.model.pj.Modifier;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TiranoJuan
 */
public class ControlesServiceImplTest {

    public ControlesServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of actividadActualPj method, of class ControlesServiceImpl.
     */
    //@Test
    public void testActividadActualPj() {
        System.out.println("actividadActualPj");
        Personaje pj = HibernateDao.obtenerPersonajePorId(1L);
        assertNotNull(pj);
        // pj.setAltura(pj.getAltura() + 5);

//        assertTrue(HibernateDao.actualizarPersonaje(pj));
        if (pj.getStatusFisico().getHeridas().isEmpty()) {
            crearHitsAlPersonaje(pj);
        } else {

            //Set<Herida> heridas = pj.getStatusFisico().getHeridas();
            Set<Herida> heridas = HibernateDao.todosLosHeridas();

            while (!heridas.isEmpty()) {
                Iterator iterator = heridas.iterator();
                Herida h = (Herida) iterator.next();
                ControlPersonajes.borrarHeridaPj(pj, h);
                heridas.remove(h);
            }

        }

        int actNeo = HibernateDao.controlActividadDePj(pj);
        assertNotNull(actNeo);

    }

    @Test
    public void testTempoEnHeridas() {
        System.out.println("testTempoEnHeridas");
        Personaje pj = HibernateDao.obtenerPersonajePorId(1L);
        assertNotNull(pj);
        // pj.setAltura(pj.getAltura() + 5);

//        assertTrue(HibernateDao.actualizarPersonaje(pj));
        if (!pj.getStatusFisico().getHeridas().isEmpty()) {

            //Set<Herida> heridas = pj.getStatusFisico().getHeridas();
            Set<Herida> heridas = pj.getStatusFisico().getHeridas();
            int porcen = 0; 
            int porcenPost =0;
            for (Iterator<Herida> iterator = heridas.iterator(); iterator.hasNext();) {
                Herida h = (Herida) iterator.next();
                porcen = h.getPorcentajeActual();
                System.out.println(" *** Herida *** \n" +  h.getId_herida() + " -> " + h.getPorcentajeActual() + "%");
                break;
            }

            Date d = ControlCampaign.avanceDelTiempo(5000, pj.getCampaign().getId_campaign());
            //Date d = ControlCampaign.avanceDelTiempo(Recursos.tiempoEnAsaltosParse(5, TIEMPO.TIEMPO_DIAS), pj.getCampaign().getId_campaign());
            System.out.println(" Nueva Fecha: " + d.toString());
            pj = HibernateDao.obtenerPersonajePorId(1L);
            heridas = pj.getStatusFisico().getHeridas();
            for (Iterator<Herida> iterator = heridas.iterator(); iterator.hasNext();) {
                Herida h = (Herida) iterator.next();
                porcenPost = h.getPorcentajeActual();                
                System.out.println(" *** Herida post actualizo el tiempo *** \n" + h.getId_herida() + " -> " + h.getPorcentajeActual() + "%");
                break;
            }
            assertTrue(porcen>porcenPost);
        }

        

    }

    private void crearHitsAlPersonaje(Personaje p) {

        /*
            Funcion auxliar, para crear golpess genericos
        
         */
//        Critico c = HibernateDao.obtenerCriticoPorId(Constantes.criticoPrueba1);
        Set<Critico> cs = HibernateDao.todosLosCriticos();
        //Critico c = cs.iterator().next();
        for (Iterator<Critico> iterator = cs.iterator(); iterator.hasNext();) {
            Damage d = new Damage();
            Critico next = iterator.next();
            d.setPv(Recursos.aleatorioEntre(1, 30));
            d.setCritico(next);
            ControlPersonajes.hitPj(d, p);
        }

    }

    private void crearBuffsAlPersonaje(Personaje p) {

//        Critico c = HibernateDao.obtenerCriticoPorId(Constantes.criticoPrueba1);
        Efecto e = new Efecto();
        e.setAnulacion_progresiva(false);
        e.setClase(Efecto.ClaseEfecto.MAGICO);
        e.setDescripcion("Inspitacion +10 a la actividad");

        Modifier m = new Modifier();
        m.setFactor(10);
        m.setPropiedad(Modifier.Propiedad.ACTIVIDAD);
        m.setOperador(Modifier.Operador.SUMA);
        e.addMod(m);

        ControlPersonajes.afectarAlPj(p, e);
    }
}
