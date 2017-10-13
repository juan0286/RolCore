package com.websystique.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.BonoExp;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.TipoObjeto;
import com.websystique.spring.service.JugadorService;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.PersonajeService;
import com.websystique.spring.service.TipoObjetoService;
import java.util.Date;
import org.springframework.core.env.Environment;

public class AppMain {

    

    public static void main(String args[]) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TipoObjetoService t_obj_service = (TipoObjetoService) context.getBean("tipoObjetoService");
        JugadorService js = (JugadorService) context.getBean("jugadorService");
        PersonajeService ps = (PersonajeService) context.getBean("personajeService");
        
        
        //Creador.crearElRol();
        

        // probar si se guardo correctamente
        long l = 1l;
        Jugador jug = js.findById(l);

        BonoExp be = new BonoExp();
        be.setPj(jug.getPj());
        be.setAplicado(true);
        be.setBono(100);
        be.setMotivo("Pruebas Dos");
        java.util.Date fecha = new Date();
        be.setFecha(fecha);
        HibernateDao.darBonoExp(be);

        
        jug = js.findById(l);
        System.out.println("****   Jugador Creado   *****");
        System.out.println(jug);
 
        context.close();
    }
}
