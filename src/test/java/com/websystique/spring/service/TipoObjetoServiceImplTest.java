/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.objetos.TipoObjeto;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author TiranoJuan
 */
public class TipoObjetoServiceImplTest {
    
    public TipoObjetoServiceImplTest() {
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
     * Test of saveTipoObjeto method, of class TipoObjetoServiceImpl.
     */
    @Test
    public void testSaveTipoObjeto() {
        System.out.println("saveTipoObjeto");
                
        TipoObjeto to = new TipoObjeto();
        to.setNombre("Objeto tipo prueba");
        to.setDegradado(100);
        to.setDurabilidad_stnd(999999);
        to.setPeso_stnd(10);
        to.setTam_stnd(99);
        
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        t_obj_service.saveTipoObjeto(to);
        
        TipoObjeto to2 = t_obj_service.findByNombre(to.getNombre());
        assertEquals(to, to2);
         t_obj_service.deleteTipoObjetoByNombre(to.getNombre());
         t_obj_service.deleteTipoObjetoByNombre(to2.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAllTipoObjetos method, of class TipoObjetoServiceImpl.
     */
    @Test
    public void testFindAllTipoObjetos() {
        System.out.println("findAllTipoObjetos");
        
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        
        TipoObjeto to = new TipoObjeto();
        to.setNombre("Objeto tipo prueba2");
        to.setDegradado(100);
        to.setDurabilidad_stnd(999999);
        to.setPeso_stnd(10);
        to.setTam_stnd(99);
        t_obj_service.saveTipoObjeto(to);
        
        Set<TipoObjeto> res = t_obj_service.findAllTipoObjetos();
        
        assertNotNull(res);
        assertNotEquals(0, res.size());
        t_obj_service.deleteTipoObjetoByNombre("Objeto tipo prueba2");
        
      
    }

    /**
     * Test of deleteTipoObjetoByNombre method, of class TipoObjetoServiceImpl.
     */
    @Test
    public void testDeleteTipoObjetoByNombre() {
        System.out.println("deleteTipoObjetoByNombre");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        
        TipoObjeto to = new TipoObjeto();
        to.setNombre("Objeto tipo prueba3");
        to.setDegradado(100);
        to.setDurabilidad_stnd(999999);
        to.setPeso_stnd(10);
        to.setTam_stnd(99);
        t_obj_service.saveTipoObjeto(to);
        t_obj_service.deleteTipoObjetoByNombre("Objeto tipo prueba3");
        TipoObjeto tores = t_obj_service.findByNombre("Objeto tipo prueba3");
        t_obj_service.deleteTipoObjetoByNombre("Objeto tipo prueba3");
        assertNull(tores);        
        
    }

    /**
     * Test of updateTipoObjeto method, of class TipoObjetoServiceImpl.
     */
    @Test
    public void testUpdateTipoObjeto() {
        System.out.println("updateTipoObjeto");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        float f = 100;
        TipoObjeto to = new TipoObjeto();
        to.setNombre("Objeto tipo prueba4");
        to.setDegradado(f);
        to.setDurabilidad_stnd(999999);
        to.setPeso_stnd(10);
        to.setTam_stnd(99);
        t_obj_service.saveTipoObjeto(to);
        //t_obj_service.deleteTipoObjetoByNombre("Objeto tipo prueba4");
        
        TipoObjeto tores = t_obj_service.findByNombre("Objeto tipo prueba4");
        assertEquals(tores.getDegradado()== f,true);
        to.setDegradado(f+5);
        t_obj_service.updateTipoObjeto(to);
        
        tores= null;
        tores = t_obj_service.findByNombre("Objeto tipo prueba4");
        assertEquals(tores.getDegradado()== f+5,true);
        
        t_obj_service.deleteTipoObjetoByNombre("Objeto tipo prueba4");
    }
    
}
