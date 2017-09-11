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
import java.util.List;
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
        System.out.println("saveObjeto");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");
        
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.get(0);
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
     * Test of findAllObjetos method, of class ObjetoDao.
     */
    @Test
    public void testFindAllObjetos() {
        System.out.println("findAllObjetos");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");
        
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.get(0);
        objeto.setTipo(to);
        
        ObjetoDao instance = new ObjetoDaoImpl();
        service.saveObjeto(objeto);

        List<Objeto> res = service.findAllObjetos();
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
        System.out.println("deleteObjetoByNombre");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");
        
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.get(0);
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
        System.out.println("findByNombre");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");
                
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.get(0);
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
        System.out.println("updateObjeto");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        service.deleteObjetoByNombre("Objeto de Prueba");
        Objeto objeto = new Objeto();
        objeto.setDegradado_actual(1500);
        objeto.setNombre("Objeto de Prueba");
        
        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        List<TipoObjeto> tobjs = t_obj_service.findAllTipoObjetos();
        TipoObjeto to = tobjs.get(0);
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

        public List<Objeto> findAllObjetos() {
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

}
