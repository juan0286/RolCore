/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.controles.comunicadores;

import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.model.pj.Efecto;
import com.websystique.spring.model.pj.Herida;
import com.websystique.spring.model.pj.StatusFisico;
import java.util.Set;

/**
 *
 * @author TiranoJuan
 */
public class HitComunicador {
    
    private int pv;
    
    private Critico critico;    
    
    private Set<Efecto> Efectos; 
    
    private Herida herida;
    
    private StatusFisico sf;
    
}
