/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.model.combate.CodeCritico;
import java.util.HashMap;

/**
 *
 * @author TiranoJuan
 */
public class Constantes {

   

    public static class Stamina {

        public final static int STAMINA_BASICA = 500;
        public final static int NUTRICION_BASICA = 500;
        public final static int HIDRATACION_BASICA = 500;
    }

    public static class TiempoEnAsaltos {

        public static HashMap<Tiempo,Integer> t = new HashMap<Tiempo,Integer>();
        //public final static int SEGUNDOS = 10;
        
        public final static int MINUTOS = 6;
        public final static int HORAS = 360;
        public final static int DIAS = 8640;
        public final static int SEMANAS = 60480;

    }

    // CLASES DE ARMAS
    public static enum Tiempo {
        SEGUNDOS,
        MINUTOS,
        HORAS,
        DIAS,
        SEMANAS,
        MESES,
        AÑOS
    }
    
    // CLASES DE ARMAS
    public static enum Clase {
        CLASE_MANO_DESNUDA,
        CLASE_ALFANJE,
        CLASE_ARCO_CORTO,
        CLASE_ARCO_LARGO,
        CLASE_BASTON,
        CLASE_CIMITARRA,
        CLASE_DAGA,
        CLASE_ESPADA_ANCHA,
        CLASE_ESPADA_CORTA,
        CLASE_ESPADON,
        CLASE_GARROTE,
        CLASE_HACHA,
        CLASE_LANZA,
        CLASE_MAZA,
        CLASE_LANZA_CABALLERIA,
        CLASE_ROMPE_CABEZAS,
        CLASE_ESCUDO
    }

    public static enum Estilo {
        ESTILO_PELEA,
        ESTILO_FILO,
        ESTILO_CONTUNDENTE,
        ESTILO_DOS_MANOS,
        ESTILO_ARROJADIZA,
        ESTILO_PROYECTILES,
        ESTILO_ASTA,
        ESTILO_BARRIDO_ARTE_MARCIAL,
        ESTILO_GOLPE_ARTE_MARCIAL,
        ESTILO_COMBO_FILO_FILO,
        ESTILO_COMBO_ASTA_FILO,
    }

    public static enum TipoAccion {
        TIPO_ACCION_SIN_ACCION,
        TIPO_ACCION_CARGA_SORTILEGIO,
        TIPO_ACCION_REALIZA_SORTILEGIO,
        TIPO_ACCION_DISPARA_PROYECTIL,
        TIPO_ACCION_CARGA_PROYECTIL,
        TIPO_ACCION_PARAR_PROYECTIL,
        TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA,
        TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO,
        TIPO_ACCION_DESPLAZAMIENTO,
        TIPO_ACCION_MOVIMIENTO_ESTATICO
    }

    public static enum TipoArma {
        TIPO_ARMA_NORMAL,
        TIPO_ARMA_MAGICA,
        TIPO_ARMA_MITRIL,
        TIPO_ARMA_SAGRADA,
        TIPO_ARMA_EXTERMINADORA
    }

    public static enum TIEMPO {
        TIEMPO_ASALTO,
        TIEMPO_SEGUNDOS,
        TIEMPO_MINUTOS,
        TIEMPO_HORAS,
        TIEMPO_DIAS,
        TIEMPO_SEMANAS

    }
    
    public static CodeCritico criticoPrueba1 = new CodeCritico(1,"E","S");
    public static CodeCritico criticoPrueba2 = new CodeCritico(1,"A","K");
    public static CodeCritico criticoPrueba18 = new CodeCritico(18,"A","S");
    public static CodeCritico criticoPrueba19 = new CodeCritico(19,"A","S");
    public static CodeCritico criticoPrueba17 = new CodeCritico(17,"A","S");
    public static CodeCritico criticoPrueba16 = new CodeCritico(16,"A","S");
    public static CodeCritico criticoPrueba15 = new CodeCritico(15,"A","S");
    public static CodeCritico criticoPrueba14 = new CodeCritico(14,"A","S");
    public static CodeCritico criticoPrueba13 = new CodeCritico(13,"A","S");
}
