/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.BonoExp;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.TipoObjeto;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import com.websystique.spring.model.caractPj.Idioma;
import com.websystique.spring.service.BonoExpService;
import com.websystique.spring.service.IdiomaService;
import com.websystique.spring.service.JugadorService;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.PersonajeService;
import com.websystique.spring.service.TipoObjetoService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.websystique.spring.service.Hab_secundariaService;

/**
 *
 * @author TiranoJuan
 */
public class HibernateDao {
    
    
    
public static void crearPersonaje(Personaje pj){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    PersonajeService service = (PersonajeService) context.getBean("personajeService");
    service.savePersonaje(pj);
    context.close();
}

public static void crearJugador(Jugador py){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    JugadorService service = (JugadorService) context.getBean("jugadorService");
    try{
    service.saveJugador(py);
    } catch (Exception ex){
        System.out.println(" Error Guardando Jugador");
        System.out.println(ex.toString());
    }
    context.close();
}

public static void crearTipoDeObjeto(TipoObjeto to){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    TipoObjetoService service = (TipoObjetoService) context.getBean("tipoObjetoService");
    try{
    service.saveTipoObjeto(to);
    } catch (Exception ex){
        System.out.println(" Error Guardando Tipo de Objeto");
        System.out.println(ex.toString());
    }
    context.close();
}

public static void crearObjeto(Objeto o){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    ObjetoService service = (ObjetoService) context.getBean("objetoService");
    try{
    service.saveObjeto(o);
    } catch (Exception ex){
        System.out.println(" Error Guardando Objeto " + o.getNombre());
        System.out.println(ex.toString());
    }
    context.close();
}

public static void darBonoExp(BonoExp be){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    BonoExpService service = (BonoExpService) context.getBean("bonoExpService");
    try{
    service.saveBonoExp(be);
    } catch (Exception ex){
        System.out.println(" Error Bonificando experiencia ");
        System.out.println(ex.toString());
    }
    context.close();
}


public static void crearIdioma(Idioma i){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    IdiomaService service = (IdiomaService) context.getBean("idiomaService");
    try{
    service.saveIdioma(i);
    } catch (Exception ex){
        System.out.println(" Error Guardando Idioma " + i.getNombre());
        System.out.println(ex.toString());
    }
    context.close();
}

public static List<Idioma> todosLosIdiomas(){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    IdiomaService service = (IdiomaService) context.getBean("idiomaService");
    List<Idioma> idiomas = null;
    try{
    idiomas = service.findAllIdiomas();
    } catch (Exception ex){
        System.out.println(" Error obteniendo todos los Idiomas ");
        System.out.println(ex.toString());
    }
    context.close();
    return idiomas;
}

public static void CrearHabSecundaria(Hab_secundaria hs){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Hab_secundariaService service = (Hab_secundariaService) context.getBean("hab_secundariaService");
    try{
    service.saveHab_secundaria(hs);
    } catch (Exception ex){
        System.out.println(" Error Guardando Habilidad Secundaria " + hs.getNombre());
        System.out.println(ex.toString());
    }
    context.close();
}

public static List<Hab_secundaria> todosLasHabilidadesSecundarias(){
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Hab_secundariaService service = (Hab_secundariaService) context.getBean("hab_secundariaService");
    List<Hab_secundaria> hss = null;
    try{
    hss = service.findAllHab_secundarias();
    } catch (Exception ex){
        System.out.println(" Error obteniendo todas las habilidades secundarias ");
        System.out.println(ex.toString());
    }
    context.close();
    return hss;
}
    
    
}
