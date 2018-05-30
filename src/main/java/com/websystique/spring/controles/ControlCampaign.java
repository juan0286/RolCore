/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.controles;

import com.websystique.spring.Constantes;
import com.websystique.spring.HibernateDao;
import com.websystique.spring.Recursos;
import com.websystique.spring.model.Campaign;
import static java.lang.Math.toIntExact;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import org.hibernate.Hibernate;

/**
 *
 * @author TiranoJuan
 */
public class ControlCampaign {

    public static HashMap<Long,Integer> validarActividad = new HashMap();
    
    public static Date avanceDelTiempo(long asaltos, long id_camp) {

        Campaign c = HibernateDao.obtenerCampaignPorId(id_camp);
        Date fch = c.getMundo().getFecha_rol();

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.SECOND, toIntExact(asaltos)*10);
        Date newFch = new Date(cal.getTimeInMillis());
        c.getMundo().setFecha_rol(newFch); 
        
        HibernateDao.actualizarTodoslosTempoDeUnaCampaign(asaltos, id_camp);
        
        HibernateDao.actualizarCampaign(c);
        
        System.out.println(" *****   EL Tiempo de la campaña "+id_camp + " ah avanzado " + asaltos + "("+ Recursos.tiempoEnAsaltosParse(asaltos, Constantes.TIEMPO.TIEMPO_DIAS) +")" );
        // proceso en segundo plano que finalice cosas
        
        
        
        
        //
        return newFch;
    }

    
    
}
