/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.dao.CampaignDao;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Master;
import com.websystique.spring.model.objetos.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.Profesion;
import com.websystique.spring.model.Tempo;
import com.websystique.spring.model.objetos.TipoObjeto;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import com.websystique.spring.model.caractPj.Idioma;
import com.websystique.spring.model.combate.CodeCritico;
import com.websystique.spring.model.messaging.PremioPregunta;
import com.websystique.spring.model.pj.Efecto;
import com.websystique.spring.model.pj.Herida;
import com.websystique.spring.service.BonoExpService;
import com.websystique.spring.service.CampaignAccessRequestService;
import com.websystique.spring.service.CampaignService;
import com.websystique.spring.service.ControlesService;
import com.websystique.spring.service.CriticoService;
import com.websystique.spring.service.EfectoService;
import com.websystique.spring.service.IdiomaService;
import com.websystique.spring.service.JugadorService;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.PersonajeService;
import com.websystique.spring.service.TipoObjetoService;
import java.util.Set;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.websystique.spring.service.Hab_secundariaService;
import com.websystique.spring.service.HeridaService;
import com.websystique.spring.service.IService;
import com.websystique.spring.service.MasterService;
import com.websystique.spring.service.PremioPreguntaService;
import com.websystique.spring.service.ProfesionService;
import com.websystique.spring.service.Servicio;
import com.websystique.spring.service.TempoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author TiranoJuan
 */
public class HibernateDao {

    private static final Logger LOGGER = Logger.getLogger(HibernateDao.class.getName());

    public static void crearPersonaje(Personaje pj) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonajeService service = (PersonajeService) context.getBean("personajeService");
        service.savePersonaje(pj);
        context.close();
    }

    public static int controlActividadDePj(Personaje pj) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ControlesService service = (ControlesService) context.getBean("controlesService");
        int r = 0;
        try {
            r = service.actividadActualPj(pj);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo Actividad de " + pj.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return r;
    }

    public static Jugador obtenerJugadorePorNombre(String name) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        Jugador j = service.findByName(name);
        context.close();
        return j;
    }

    public static Jugador obtenerJugadorPorUsuario(String user) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        Jugador j = service.findByUser(user);
        context.close();
        return j;
    }

    public static Jugador obtenerJugadorPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        Jugador j = service.findById(id);
        context.close();
        return j;
    }

    public static Jugador obtenerJugadorPorIdFirebase(String idFirebase) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        Jugador j = service.findByIdFirebase(idFirebase);
        context.close();
        return j;
    }

    public static boolean crearJugador(Jugador py) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        boolean succ = true;

        try {
            service.saveJugador(py);
        } catch (Exception ex) {
            succ = false;
            LOGGER.log(Level.SEVERE, " Error Guardando Jugador");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return succ;

    }

    public static Master obtenerMPorNombre(String name) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service = (MasterService) context.getBean("masterService");
        Master m = service.findByName(name);
        context.close();
        return m;
    }

    public static Master obtenerMasterPorUsuario(String user) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service = (MasterService) context.getBean("masterService");
        Master m = service.findByUser(user);
        context.close();
        return m;
    }

    public static Master obtenerMasterPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service = (MasterService) context.getBean("masterService");
        Master m = service.findById(id);
        context.close();
        return m;
    }

    public static BonoExp obtenerBonoExp(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
        BonoExp be = null;
        try {
            be = service.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo BonoExp");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return be;
    }

    public static void crearMaster(Master py) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service = (MasterService) context.getBean("masterService");
        try {
            service.saveMaster(py);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Master");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void crearCar(CampaignAccessRequest car) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        try {
            service.saveCampaignAccessRequest(car);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando car");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void crearCar(CampaignAccessRequest car, long id_j, long id_c) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        try {
            service.saveCampaignAccessRequest(car, id_j, id_c);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando car");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void crearTipoDeObjeto(TipoObjeto to) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService service = (TipoObjetoService) context.getBean("tipoObjetoService");
        try {
            service.saveTipoObjeto(to);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Tipo de Objeto");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void crearObjeto(Objeto o) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        try {
            service.saveObjeto(o);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Objeto " + o.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void darBonoExp(BonoExp be) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
        try {
            service.saveBonoExp(be);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Bonificando experiencia ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static void crearIdioma(Idioma i) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IdiomaService service = (IdiomaService) context.getBean("idiomaService");
        try {
            service.saveIdioma(i);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Idioma " + i.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Idioma> todosLosIdiomas() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IdiomaService service = (IdiomaService) context.getBean("idiomaService");
        Set<Idioma> idiomas = null;
        try {
            idiomas = service.findAllIdiomas();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Idiomas ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return idiomas;
    }

    public static void crearHabSecundaria(Hab_secundaria hs) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Hab_secundariaService service = (Hab_secundariaService) context.getBean("hab_secundariaService");
        try {
            service.saveHab_secundaria(hs);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Habilidad Secundaria " + hs.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static boolean crearCampaignYAddAlMaster(Campaign c, Master m) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service_cam = (CampaignService) context.getBean("campaignService");
        MasterService service_mas = (MasterService) context.getBean("masterService");
        boolean succ = true;

        Set<Campaign> cExistentes = m.getCampaigns();
        if (!cExistentes.contains(c)) {
            c.setMaster(m);
            service_cam.saveCampaign(c);
            m.getCampaigns().add(c);
            service_mas.updateMaster(m);
        } else {
            succ = false;
            LOGGER.log(Level.SEVERE, "Ya existe una campaña con este nombre");
        }
        context.close();
        return succ;
    }

    public static boolean crearCampaign(Campaign c) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service_cam = (CampaignService) context.getBean("campaignService");
        MasterService service_mas = (MasterService) context.getBean("masterService");
        boolean succ = true;
        try {
            service_cam.saveCampaign(c);
//    Master m = c.getMaster();
            //  service_mas.updateMaster(c.getMaster());
        } catch (Exception ex) {
            succ = false;
            LOGGER.log(Level.SEVERE, " Error Guardando la campaña " + c.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return succ;
    }

//public static Campaign obtenerCampaignPorUsuario(String user){
//    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//    CampaignService service = (CampaignService) context.getBean("campaignService");
//    Campaign c = service.findByUser(user);
//    context.close();
//    return c;
//}
    public static Campaign obtenerCampaignPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        Campaign c = service.findById(id);
        //Hibernate.initialize(c.getJugadores());
        //Hibernate.initialize(c.getMundo());
        //Hibernate.initialize(c.getBonosExp());    
        context.close();
        return c;
    }

    public static Objeto obtenerObjetoPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ObjetoService service = (ObjetoService) context.getBean("objetoService");
        Objeto o = service.findById(id);
        //Hibernate.initialize(c.getJugadores());
        //Hibernate.initialize(c.getMundo());
        //Hibernate.initialize(c.getBonosExp());    
        context.close();
        return o;
    }

    public static TipoObjeto obtenerTIpoObjetoPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TipoObjetoService service = (TipoObjetoService) context.getBean("tipoObjetoService");
        TipoObjeto o = service.findById(id);
        context.close();
        return o;
    }

    public static Personaje obtenerPersonajePorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonajeService service = (PersonajeService) context.getBean("personajeService");
        Personaje p = service.findById(id);
        context.close();
        return p;
    }

//    public static Object obtenerPorId(long id,Object o) {
//
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Object service = (o.getClass()) context.getBean(o.getClass().getSimpleName());
//        Object or = service.findById(id);        
//        context.close();
//        return or;
//    }
    public static Campaign obtenerCampaignPorNombre(String nombre) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");

        Campaign c = service.findByName(nombre);
//    Hibernate.initialize(c.getJugadores());
//    Hibernate.initialize(c.getBonosExp());
        context.close();
        return c;
    }

    public static void actualizarCampaign(Campaign c) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        service.updateCampaign(c);
        context.close();
    }

    public static void actualizarJugador(Jugador j) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JugadorService service = (JugadorService) context.getBean("jugadorService");
        service.updateJugador(j);
        context.close();
    }

    public static boolean actualizarPersonaje(Personaje p) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonajeService service = (PersonajeService) context.getBean("personajeService");

        boolean succ = true;
        try {
            service.updatePersonaje(p);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando Pj " + p);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }

    public static boolean actualizarBonoExp(BonoExp p) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");

        boolean succ = true;
        try {
            service.updateBonoExp(p);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando Pj " + p);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }

    public static boolean actualizarHerida(Herida h) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");

        boolean succ = true;
        try {
            service.updateHerida(h);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando herida " + h);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }

    public static void borrarCampaignAccessRequest(long id_car, long id_pj, long id_campaign) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        service.deleteCarComplete(id_car, id_pj, id_campaign);
        context.close();
    }

    public static void borrarCampaignAccessRequest(long id_car) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequest");
        service.deleteCampaignAccessRequestById(id_car);
        context.close();
    }

    public static Set<Personaje> todosLosPjsDeUnaCampaign(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonajeService service = (PersonajeService) context.getBean("personajeService");

        Set<Personaje> pjs = null;
        try {
            pjs = service.findAllPersonajesFromCampaign(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todas los Personajes de la camppaña con id " + id);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return pjs;

    }

    public static boolean borrarCampaignPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        service.deleteCampaignById(id);
//    Hibernate.initialize(c.getJugadores());
//    Hibernate.initialize(c.getBonosExp());
        context.close();
        return true;
    }

    public static Set<Hab_secundaria> todosLasHabilidadesSecundarias() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Hab_secundariaService service = (Hab_secundariaService) context.getBean("hab_secundariaService");
        Set<Hab_secundaria> hss = null;
        try {
            hss = service.findAllHab_secundarias();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todas las habilidades secundarias ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return hss;
    }

    public static Set<Campaign> todosLasCampaignsXNombre(String nombre) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        Set<Campaign> hss = null;
        try {
            hss = service.findAllCampaignsNombre(nombre);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todas las campañas de nombre " + nombre);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return hss;
    }

    public static Set<Campaign> todosLasCampaignsXMaster(Master m) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        Set<Campaign> hss = null;
        try {
            hss = service.findAllCampaignsMaster(m);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todas las campañas del master " + m.toString());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return hss;
    }

    public static Set<Campaign> todosLasCampaignsNuevasXMaster(String param, long id_j, CampaignDao.TypeSearch tipo) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignService service = (CampaignService) context.getBean("campaignService");
        Set<Campaign> hss = null;
        try {
            hss = service.findAllNewCampaignsPorMaster(param, id_j, tipo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todas las campañas buscadas. PARAM =" + param);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);

        }
        context.close();
        return hss;
    }

    public static Set<BonoExp> todosLosBonosExpDeUnPj(Personaje pj) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
        Set<BonoExp> bes = null;
        try {
            bes = service.findAllBonoExpsForPj(pj);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Bonos de Exp. de " + pj.getNombre());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return bes;
    }

    public static Set<CampaignAccessRequest> todosLosCarDeUnaCampaign(Campaign c) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        Set<CampaignAccessRequest> bes = null;
        try {
            bes = service.findAllCampaignAccessRequestsFromCampaign(c);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Car de " + c.getNombre() + " - " + c.getId_campaign());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return bes;
    }

    public static Set<CampaignAccessRequest> todosLosCarDeUnJugador(Jugador j) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        Set<CampaignAccessRequest> bes = null;
        try {
            bes = service.findAllCampaignAccessRequestsFromPlayer(j);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Car de " + j.getNombre() + " - " + j.getId_jugador());
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return bes;
    }

    public static void actualizarMaster(Master m) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service_mas = (MasterService) context.getBean("masterService");

        service_mas.updateMaster(m);
        context.close();

    }

    public static void aceptarCar(long id_car) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service_car = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        service_car.updateStatusCARTo(id_car, CampaignAccessRequest.estado.ACEPTADA);
        context.close();
    }

    public static void rechazarCar(long id_car) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service_car = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        service_car.updateStatusCARTo(id_car, CampaignAccessRequest.estado.RECHAZADA);
        context.close();
    }

    public static void esperarCar(long id_car) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service_car = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        service_car.updateStatusCARTo(id_car, CampaignAccessRequest.estado.ESPERA);
        context.close();
    }

    static boolean borrarMasterPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service_mas = (MasterService) context.getBean("masterService");
        boolean succ = true;
        try {
            service_mas.deleteMasterById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando Master con id " + id);
            succ = false;
        }
        return succ;
    }

    static boolean borrarCarPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CampaignAccessRequestService service_mas = (CampaignAccessRequestService) context.getBean("campaignAccessRequestService");
        boolean succ = true;
        try {
            service_mas.deleteCampaignAccessRequestById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    static void borrarMasterPorIdNotReturn(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MasterService service_mas = (MasterService) context.getBean("masterService");
        service_mas.deleteMasterById(id);
    }

    public static long crearBonoExp(BonoExp be) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
        long succ = -1L;
        try {
            service.saveBonoExp(be);
            succ = be.getId_bonoexp();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo creando bonoExp " + be);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        LOGGER.log(Level.FINE, "Se ah creado bonoExp " + be.getId_bonoexp());
        return succ;

    }

    public static boolean borrarBonoExp(BonoExp be) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
        boolean succ = true;
        try {
            service.deleteBonoExpById(be.getId_bonoexp());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando bonoExp " + be);
            succ = false;
        }
        return succ;
    }

    public static PremioPregunta obtenerPremioPreguntaPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PremioPreguntaService service = (PremioPreguntaService) context.getBean("premioPreguntaService");
        PremioPregunta o = service.findById(id);
        context.close();
        return o;
    }

    public static void crearPremioPregunta(PremioPregunta premioPregunta) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PremioPreguntaService service = (PremioPreguntaService) context.getBean("premioPreguntaService");
        try {
            service.savePremioPregunta(premioPregunta);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Habilidad Secundaria " + premioPregunta);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<PremioPregunta> todosLosPremioPreguntas() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PremioPreguntaService service = (PremioPreguntaService) context.getBean("premioPreguntaService");
        Set<PremioPregunta> premioPreguntas = null;
        try {
            premioPreguntas = service.findAllPremioPreguntas();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los PremioPreguntas ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return premioPreguntas;
    }

    static boolean borrarPremioPreguntaPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PremioPreguntaService service = (PremioPreguntaService) context.getBean("premioPreguntaService");
        boolean succ = true;
        try {
            service.deletePremioPreguntaById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    public static Profesion obtenerProfesionPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProfesionService service = (ProfesionService) context.getBean("profesionService");
        Profesion o = service.findById(id);
        context.close();
        return o;
    }

    public static Profesion obtenerProfesionPorNombre(String nombre) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProfesionService service = (ProfesionService) context.getBean("profesionService");
        Profesion o = service.findByName(nombre);
        context.close();
        return o;
    }

    public static void crearProfesion(Profesion profesion) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProfesionService service = (ProfesionService) context.getBean("profesionService");
        try {
            service.saveProfesion(profesion);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Habilidad Secundaria " + profesion);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Profesion> todasLosProfesiones() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProfesionService service = (ProfesionService) context.getBean("profesionService");
        Set<Profesion> profesions = null;
        try {
            profesions = service.findAllProfesions();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Profesions ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return profesions;
    }

    static boolean borrarProfesionPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProfesionService service = (ProfesionService) context.getBean("profesionService");
        boolean succ = true;
        try {
            service.deleteProfesionById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    public static Herida obtenerHeridaPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");
        Herida o = service.findById(id);
        context.close();
        return o;
    }

    public static void crearHerida(Herida herida) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");
        try {
            service.saveHerida(herida);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Herida " + herida);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Herida> todosLosHeridas() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");
        Set<Herida> heridas = null;
        try {
            heridas = service.findAllHeridas();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Heridas ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return heridas;
    }

    static boolean borrarHeridaPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");
        boolean succ = true;
        try {
            service.deleteHeridaById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    public static Efecto obtenerEfectoPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EfectoService service = (EfectoService) context.getBean("efectoService");
        Efecto o = null;
        try {
            o = service.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Profesions ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return o;
    }

    public static void crearEfecto(Efecto efecto) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EfectoService service = (EfectoService) context.getBean("efectoService");
        try {
            service.saveEfecto(efecto);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Habilidad Secundaria " + efecto);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Efecto> todosLosEfectos() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EfectoService service = (EfectoService) context.getBean("efectoService");
        Set<Efecto> efectos = null;
        try {
            efectos = service.findAllEfectos();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Efectos ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return efectos;
    }

    static boolean borrarEfectoPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EfectoService service = (EfectoService) context.getBean("efectoService");
        boolean succ = true;
        try {
            service.deleteEfectoById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    public static Critico obtenerCriticoPorId(CodeCritico id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CriticoService service = (CriticoService) context.getBean("criticoService");
        Critico o = null;
        try {
            o = service.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Obteniendo Critico " + o);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return o;
    }

    public static void crearCritico(Critico critico) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CriticoService service = (CriticoService) context.getBean("criticoService");
        try {
            service.saveCritico(critico);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Critico " + critico);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Critico> todosLosCriticos() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CriticoService service = (CriticoService) context.getBean("criticoService");
        Set<Critico> criticos = null;
        try {
            criticos = service.findAllCriticos();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Criticos ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return criticos;
    }

    static boolean borrarCriticoPorId(CodeCritico id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CriticoService service = (CriticoService) context.getBean("criticoService");
        boolean succ = true;
        try {
            service.deleteCriticoById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando Critico con id " + id);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }

    static public int actividadDePj(Personaje pj) {
        return 3;
    }

    public static boolean borrarHerida(Herida h) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HeridaService service = (HeridaService) context.getBean("heridaService");
        boolean succ = true;
        try {
            service.deleteHeridaById(h.getId_herida());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando Herida " + h);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;

    }

    public static Tempo obtenerTempoPorId(long id) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("tempoService");
        Tempo o = service.findById(id);
        context.close();
        return o;
    }

    public static void crearTempo(Tempo tempo) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("tempoService");
        try {
            service.saveTempo(tempo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error Guardando Habilidad Secundaria " + tempo);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
    }

    public static Set<Tempo> todosLosTempos() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("tempoService");
        Set<Tempo> tempos = null;
        try {
            tempos = service.findAllTempos();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, " Error obteniendo todos los Tempos ");
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        context.close();
        return tempos;
    }

    static boolean borrarTempoPorId(long id) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("tempoService");
        boolean succ = true;
        try {
            service.deleteTempoById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo borrando car con id " + id);
            succ = false;
        }
        return succ;
    }

    public static boolean actualizarTempo(Tempo p) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("TempoService");        
        boolean succ = true;
        try {
            service.updateTempo(p);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando tempo " + p);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }
    
    public static boolean actualizarTodoslosTempoDeUnaCampaign(long asaltos, long id_campaign) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TempoService service = (TempoService) context.getBean("tempoService");       
        boolean succ = true;
        try {
            service.updateTemposCampaign(asaltos, id_campaign);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando todos los tempo de campaign " + id_campaign);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }
    
    public static boolean actualizar(String clase, Object objActualizar) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IService service = (IService) context.getBean(clase);
        boolean succ = true;
        try {
            service.save(objActualizar);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando " + objActualizar);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }
    
    public static boolean save(String clase, Object objAGuardar) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IService service = (IService) context.getBean(clase);
        boolean succ = true;
        try {
            service.save(objAGuardar);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Fallo actualizando todos los tempo de campaign " + objAGuardar);
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            succ = false;
        }
        return succ;
    }

}
