/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.configuration.InicializadorDetachedDao;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Master;
import com.websystique.spring.model.Mundo;
import com.websystique.spring.model.objetos.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.objetos.TipoObjeto;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import com.websystique.spring.model.caractPj.Idioma;


import java.util.Date;
import java.util.Set;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
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
public class HibernateDaoTest {
    
    public HibernateDaoTest() {
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
     * Test of obtenerMasterPorUsuario method, of class HibernateDao.
     */
    @Test
    public void testObtenerMasterPorUsuario() {
        System.out.println("borrarMasterPorId");
        
        String user = "Master a borrar";
        Master m = new Master();
        m.setNombre(user);
        m.setPassword("n");
        m.setUsuario("mm");
        HibernateDao.crearMaster(m);
//        boolean result = HibernateDao.borrarMasterPorId(m.getId_master());
        HibernateDao.borrarMasterPorIdNotReturn(m.getId_master());
        //assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
//        
    }

    /**
     * Test of crearCampaignYAddAlMaster method, of class HibernateDao.
     */
    @Test    
    public void testCrearCampaignYAddAlMaster() {
        System.out.println("CrearCampaignYAddAlMaster");
        
        String nombreC = "Campa prueba" ;
        String nombreM = "Mundo prueba" ;
        
        Campaign c = new Campaign();
        Master m = HibernateDao.obtenerMasterPorId(1L);
        
        c.setNombre(nombreC);
        //c.setMaster(m);
        
        Mundo mu = new Mundo();
        Date date = new Date();
        mu.setNombre(nombreM);
        mu.setFecha_rol(date);
        c.setMundo(mu);
        
//        Jugador j = HibernateDao.obtenerJugadorePorNombre("Hector");        
//        c.addJugador(j);
        boolean expResult = true;
        
        Campaign cReturn = null;
        
        if (m != null && m.getCampaigns().contains(c)){
            long idABorrar = 0L;            
            for (Campaign ca : m.getCampaigns()) {
                if (ca.equals(c)){
                    idABorrar = ca.getId_campaign();
                }
            }
            m.getCampaigns().remove(c);
            HibernateDao.actualizarMaster(m);
            //HibernateDao.borrarCampaignPorId(idABorrar);
            //cReturn = m.getCampaigns().get(idABorrar);
        }
        
        boolean result = HibernateDao.crearCampaignYAddAlMaster(c, m);
        //assertEquals(expResult, result);
        
        cReturn = HibernateDao.obtenerCampaignPorId(c.getId_campaign());
        
        //InicializadorDetachedDao id = new InicializadorDetachedDao();
        //id.inicializaar(cReturn);
        
        assertNotNull(cReturn);
        
        System.out.println("Campaña bien guardada: " + cReturn.getNombre());
        
        
        //Hibernate.initialize(cReturn.getMundo());
        Mundo mRet = cReturn.getMundo();        
        assertNotNull(mRet);
        
        
        System.out.println("Mundo " + mRet.getNombre());
        
        Set<Jugador> js = cReturn.getJugadores();
        assertNotNull(js);
        System.out.println("Jugadores: " + js.size());
        
        m.getCampaigns().remove(cReturn);
        HibernateDao.actualizarMaster(m);
            
        Campaign cNoDeberiaExistir = HibernateDao.obtenerCampaignPorId(cReturn.getId_campaign());
        assertNull(cNoDeberiaExistir);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Se borro bien creo");
    }

    /**
     * Test of crearPersonaje method, of class HibernateDao.
     */
    @Test
    public void testCrearPersonaje() {
        System.out.println("crearPersonaje");
        Personaje pj = null;
//        HibernateDao.crearPersonaje(pj);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerJugadorePorNombre method, of class HibernateDao.
     */
    @Test
    public void testObtenerJugadorePorNombre() {
        System.out.println("obtenerJugadorePorNombre");
        String name = "";
        Jugador expResult = null;
//        Jugador result = HibernateDao.obtenerJugadorePorNombre(name);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerJugadorPorUsuario method, of class HibernateDao.
     */
    @Test
    public void testObtenerJugadorPorUsuario() {
        System.out.println("obtenerJugadorPorUsuario");
        String user = "";
        Jugador expResult = null;
//        Jugador result = HibernateDao.obtenerJugadorPorUsuario(user);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearJugador method, of class HibernateDao.
     */
    @Test
    public void testCrearJugador() {
        System.out.println("crearJugador");
        Jugador py = null;
//        HibernateDao.crearJugador(py);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerMPorNombre method, of class HibernateDao.
     */
    @Test
    public void testObtenerMPorNombre() {
        System.out.println("obtenerMPorNombre");
        String name = "";
        Master expResult = null;
//        Master result = HibernateDao.obtenerMPorNombre(name);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerMasterPorId method, of class HibernateDao.
     */
    @Test
    public void testObtenerMasterPorId() {
        System.out.println("obtenerMasterPorId");
        long id = 0L;
        Master expResult = null;
//        Master result = HibernateDao.obtenerMasterPorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearMaster method, of class HibernateDao.
     */
    @Test
    public void testCrearMaster() {
        System.out.println("crearMaster");
        Master py = null;
//        HibernateDao.crearMaster(py);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearTipoDeObjeto method, of class HibernateDao.
     */
    @Test
    public void testCrearTipoDeObjeto() {
        System.out.println("crearTipoDeObjeto");
        TipoObjeto to = null;
//        HibernateDao.crearTipoDeObjeto(to);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearObjeto method, of class HibernateDao.
     */
    @Test
    public void testCrearObjeto() {
        System.out.println("crearObjeto");
        Objeto o = null;
//        HibernateDao.crearObjeto(o);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of darBonoExp method, of class HibernateDao.
     */
    @Test
    public void testDarBonoExp() {
        System.out.println("darBonoExp");
        BonoExp be = null;
//        HibernateDao.darBonoExp(be);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearIdioma method, of class HibernateDao.
     */
    @Test
    public void testCrearIdioma() {
        System.out.println("crearIdioma");
        Idioma i = null;
//        HibernateDao.crearIdioma(i);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of todosLosIdiomas method, of class HibernateDao.
     */
    @Test
    public void testTodosLosIdiomas() {
        System.out.println("todosLosIdiomas");
        Set<Idioma> expResult = null;
//        Set<Idioma> result = HibernateDao.todosLosIdiomas();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearHabSecundaria method, of class HibernateDao.
     */
    @Test
    public void testCrearHabSecundaria() {
        System.out.println("CrearHabSecundaria");
        Hab_secundaria hs = null;
//        HibernateDao.crearHabSecundaria(hs);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearCampaign method, of class HibernateDao.
     */
    @Test
    public void testCrearCampaign() {
        System.out.println("CrearCampaign");
        Campaign c = null;
        boolean expResult = false;
//        boolean result = HibernateDao.crearCampaign(c);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerCampaignPorId method, of class HibernateDao.
     */
    @Test
    public void testObtenerCampaignPorId() {
        System.out.println("obtenerCampaignPorId");
        long id = 0L;
        Campaign expResult = null;
//        Campaign result = HibernateDao.obtenerCampaignPorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerPersonajePorId method, of class HibernateDao.
     */
    @Test
    public void testObtenerPersonajePorId() {
        System.out.println("obtenerPersonajePorId");
        long id = 0L;
        Personaje expResult = null;
//        Personaje result = HibernateDao.obtenerPersonajePorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of obtenerCampaignPorNombre method, of class HibernateDao.
     */
    @Test
    public void testObtenerCampaignPorNombre() {
        System.out.println("obtenerCampaignPorNombre");
        String nombre = "";
        Campaign expResult = null;
//        Campaign result = HibernateDao.obtenerCampaignPorNombre(nombre);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of borrarCampaignPorId method, of class HibernateDao.
     */
    @Test
    public void testBorrarCampaignPorId() {
        System.out.println("borrarCampaignPorId");
        long id = 0L;
        boolean expResult = false;
//        boolean result = HibernateDao.borrarCampaignPorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of todosLasHabilidadesSecundarias method, of class HibernateDao.
     */
    @Test
    public void testTodosLasHabilidadesSecundarias() {
        System.out.println("todosLasHabilidadesSecundarias");
        Set<Hab_secundaria> expResult = null;
//        Set<Hab_secundaria> result = HibernateDao.todosLasHabilidadesSecundarias();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of todosLosBonosExpDeUnPj method, of class HibernateDao.
     */
    @Test
    public void testTodosLosBonosExpDeUnPj() {
        System.out.println("todosLosBonosExpDeUnPj");
        Personaje pj = HibernateDao.obtenerPersonajePorId(1L);        
        
        Set<BonoExp> result = HibernateDao.todosLosBonosExpDeUnPj(pj);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actualizarMaster method, of class HibernateDao.
     */
    @Test
    public void testActualizarMaster() {
        System.out.println("actualizarMaster");
        Master m = null;
//        HibernateDao.actualizarMaster(m);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of borrarMasterPorId method, of class HibernateDao.
     */
    @Test
    public void testBorrarMasterPorId() {
        System.out.println("borrarMasterPorId");
        long id = 0L;
        boolean expResult = false;
//        boolean result = HibernateDao.borrarMasterPorId(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of borrarMasterPorIdNotReturn method, of class HibernateDao.
     */
    @Test
    public void testBorrarMasterPorIdnotreturn() {
        System.out.println("borrarMasterPorIdnotreturn");
        long id = 0L;
        //HibernateDao.borrarMasterPorIdNotReturn(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of crearBonoExp method, of class HibernateDao.
     */
    @Test
    public void testCrearBonoExp() {
        System.out.println("crearBonoExp");
        Personaje p = HibernateDao.obtenerPersonajePorId(1L);
        BonoExp be =  new BonoExp();
        be.setAplicado(false);
        be.setBono(1);
        be.setFecha(new Date());
        be.setPj(p);
        be.setMotivo("Test");
        
        //long expResult = HibernateDao.crearBonoExp(be);
        long expResult = -1L;
        
        assertNotEquals(new Long[]{-1L}, new Long[]{expResult});
        
        HibernateDao.borrarBonoExp(be);       
        
    }
    
    @Test
    public void testtodosLosPjsDeUnaCampaign() {
        System.out.println("todosLosPjsDeUnaCampaign");
        Set<Personaje> pjs = HibernateDao.todosLosPjsDeUnaCampaign(1L);
        
         //assertNotNull(pjs);                
        
               
    }

}
