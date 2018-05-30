package com.websystique.spring;

import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.model.combate.Damage;
import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.spring.configuration.AppConfig;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.objetos.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.objetos.TipoObjeto;
import com.websystique.spring.service.JugadorService;
import com.websystique.spring.service.ObjetoService;
import com.websystique.spring.service.PersonajeService;
import com.websystique.spring.service.TipoObjetoService;
import java.util.Date;
import org.springframework.core.env.Environment;

public class AppMain {

    public static void main(String args[]) {
       
        Creador.crearElRol();
      
    }
}
