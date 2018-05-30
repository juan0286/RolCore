/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.Constantes.*;
import com.websystique.spring.Constantes.TiempoEnAsaltos;
import java.util.ArrayList;

/**
 *
 * @author TiranoJuan
 */
public class Recursos {

    public static float asaltosEnTiempo(int cant, Constantes.TIEMPO t) {

//       if (t == Constantes.TIEMPO.TIEMPO_MINUTOS) {
//            return (cant / 10);
//        }
        if (t == Constantes.TIEMPO.TIEMPO_MINUTOS) {
            return (cant / 6);
        }
        if (t == Constantes.TIEMPO.TIEMPO_HORAS) {
            return (cant / 360);
        }
        if (t == Constantes.TIEMPO.TIEMPO_DIAS) {
            return (cant / 8640);
        }
        if (t == Constantes.TIEMPO.TIEMPO_SEMANAS) {
            return (cant / 60480);
        } else {
            return cant;
        }
    }
    
    public static long asaltosEnTiempo(long cant, Constantes.TIEMPO t) {

        int n = (int) cant;
        return asaltosEnTiempo(cant, t);
    }

    public static int tiempoEnAsaltosParse(int cant, Constantes.TIEMPO t) {
        if (t == Constantes.TIEMPO.TIEMPO_MINUTOS) {
            return (cant * 6);
        }
        if (t == Constantes.TIEMPO.TIEMPO_HORAS) {
            return (cant * 6 * 60);
        }
        if (t == Constantes.TIEMPO.TIEMPO_DIAS) {
            return (cant * 6 * 60 * 24);
        }
        if (t == Constantes.TIEMPO.TIEMPO_SEMANAS) {
            return (cant * 6 * 60 * 24 * 7);
        } else {
            return cant;
        }

    }
    public static long tiempoEnAsaltosParse(long cant, Constantes.TIEMPO t) {
        int n = (int) cant;
        return tiempoEnAsaltosParse(0, t);
    }

    public static int aleatorioEntre(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static Object aleatorioDe(ArrayList lista) {

        if (lista.size() == 0) {
            return null;
        }
        return lista.get(aleatorioEntre(0, lista.size() - 1));
    }

}
