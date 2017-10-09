/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.Objeto;
import com.websystique.spring.model.TipoObjeto;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.TipoObjetoService;
import java.math.BigDecimal;
import java.util.Set;
import org.joda.time.LocalDate;
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
public class ObjetoDaoTest {

    ObjetoService service;
    TipoObjetoService t_obj_service;

    public ObjetoDaoTest() {        
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
     * Test of saveObjeto method, of class ObjetoDao.
     */
    @Test
    public void testSaveObjeto() {
        tenerObjetos();
        System.out.println("saveObjeto");
        
        String nombre = "Objeto de Prueba save";

        service.deleteObjetoByNombre(nombre);
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre(nombre);
        
        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.iterator().next();
        objeto.setTipo(to);

        
        service.saveObjeto(objeto);

        Objeto res = service.findByNombre(nombre);
        assertNotNull(res);
        assertEquals(objeto, res);
        service.deleteObjetoByNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAllObjetos method, of class ObjetoDao.
     */
    @Test
    public void testFindAllObjetos() {
        tenerObjetos();
        System.out.println("findAllObjetos");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        
        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.iterator().next();

        Set<Objeto> res = service.findAllObjetos();
        assertNotNull(res);
        assertNotEquals(0, res.size());
        service.deleteObjetoByNombre("Objeto de Prueba");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteObjetoByNombre method, of class ObjetoDao.
     */
    @Test
    public void testDeleteObjetoByNombre() {
        tenerObjetos();
        System.out.println("deleteObjetoByNombre");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");

        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");

        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.iterator().next();
        objeto.setTipo(to);

        ObjetoDao instance = new ObjetoDaoImpl();
        service.saveObjeto(objeto);

        Objeto res = service.findByNombre("Objeto de Prueba");
        assertNotNull(res);
        assertEquals(objeto, res);

        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto res2 = service.findByNombre("Objeto de Prueba");
        assertNull(res2);

//        assertNotNull(res);
//        assertNotEquals(0, res.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByNombre method, of class ObjetoDao.
     */
    @Test
    public void testFindByNombre() {
        tenerObjetos();
        System.out.println("findByNombre");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");

        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.iterator().next();
        objeto.setTipo(to);

        ObjetoDao instance = new ObjetoDaoImpl();
        service.saveObjeto(objeto);

        Objeto res = service.findByNombre("Objeto de Prueba");
        assertNotNull(res);
        assertEquals(objeto, res);
        service.deleteObjetoByNombre("Objeto de Prueba");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateObjeto method, of class ObjetoDao.
     */
    @Test
    public void testUpdateObjeto() {
        tenerObjetos();
        System.out.println("updateObjeto");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");

        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.iterator().next();
        objeto.setTipo(to);

        ObjetoDao instance = new ObjetoDaoImpl();
        service.saveObjeto(objeto);

        Objeto res = service.findByNombre("Objeto de Prueba");
        assertNotNull(res);
        assertEquals(objeto, res);

        objeto.setDegradado_actual(40);
        service.updateObjeto(objeto);

        Objeto res2 = service.findByNombre("Objeto de Prueba");
        assertNotNull(res2);
        assertEquals(objeto, res2);

        service.deleteObjetoByNombre("Objeto de Prueba");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class ObjetoDaoImpl implements ObjetoDao {

        public void saveObjeto(Objeto objeto) {
        }

        public Set<Objeto> findAllObjetos() {
            return null;
        }

        public void deleteObjetoByNombre(String ssn) {
        }

        public Objeto findByNombre(String ssn) {
            return null;
        }

        public void updateObjeto(Objeto objeto) {
        }
    }

    
    private void tenerObjetos (){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        service = (ObjetoService) context.getBean("objetoService");
        t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");

        Set<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        if (tobjs.isEmpty()) {
            TipoObjeto to_p = new TipoObjeto();
            to_p.setDegradado(10);
            to_p.setDurabilidad_stnd(10);
            to_p.setNombre("tipo objeto de prueba");
            to_p.setPeso_stnd(10);
            to_p.setTam_stnd(10);
            
            t_obj_service.saveTipoObjeto(to_p);
            
            Objeto objeto = new Objeto();
            objeto.setDegradado_actual(1500);
            objeto.setNombre("Objeto de Prueba basico");
            objeto.setTipo(to_p);
            service.saveObjeto(objeto);
        }
    }
    
}
