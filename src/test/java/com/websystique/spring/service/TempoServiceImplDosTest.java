/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.HibernateDao;
import com.websystique.spring.model.Tempo;
import java.util.Date;
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
public class TempoServiceImplDosTest {
    
    public TempoServiceImplDosTest() {
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
     * Test of save method, of class TempoServiceImplDos.
     */
    @Test
    public void testSave() {
        System.out.println("save tempo Dos");
        
        
        Tempo t = new Tempo();
        t.setCaducidad(6543L);
        t.setFin(new Date());
        t.setInicio(new Date());
        t.setTranscurso(1321L);
       // boolean succes = HibernateDao.save("tempoServiceDos", t);
        //assertTrue(succes);
        
    }

    
    
}
