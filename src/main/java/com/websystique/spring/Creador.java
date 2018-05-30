/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring;

import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.model.Area;
import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.Info;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Master;
import com.websystique.spring.model.Mundo;
import com.websystique.spring.model.objetos.Objeto;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.Profesion;
import com.websystique.spring.model.objetos.TipoObjeto;
import com.websystique.spring.model.campaign.Historia;
import com.websystique.spring.model.caractPj.Caracteristicas;
import com.websystique.spring.model.caractPj.Hab_armadura;
import com.websystique.spring.model.caractPj.Hab_armas;
import com.websystique.spring.model.caractPj.Hab_generales;
import com.websystique.spring.model.caractPj.Hab_magicas;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import com.websystique.spring.model.caractPj.Hab_secundaria_desarrollo;
import com.websystique.spring.model.caractPj.Hab_subterfugio;
import com.websystique.spring.model.caractPj.Habilidades;
import com.websystique.spring.model.caractPj.Idioma;
import com.websystique.spring.model.caractPj.Idioma_desarrollo;
import com.websystique.spring.model.caractPj.ProfesionDesarrollo;
import com.websystique.spring.model.caractPj.Resistencias;
import com.websystique.spring.model.combate.CodeCritico;
import com.websystique.spring.model.objetos.BolsaDeMonedas;
import com.websystique.spring.model.objetos.CajaObjetos;
import com.websystique.spring.model.objetos.ObjetoPortado;
import com.websystique.spring.model.pj.ModFisico;
import com.websystique.spring.model.pj.Modifier;
import com.websystique.spring.model.pj.StatusFisico;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TiranoJuan
 */
public class Creador {

    public static void crearElRol() {

        // creacion de idiomas
        crearIdiomas();

        // creacion de Habilidades Secundarias
        crearHabilidadesSecundarias();

        // creacion de Armas
        // creacion de Objetos
        crearObjetos();
        // creacion de Localidades

        // creacion de Sortilegios
        //creacion de personajes
        crearProfesiones();

        //carga de criticos
        cargaCriticos();
        crearNeo();
        crearAdminMaster();
        crearCampaign();

    }

    public static void crearAdminMaster() {

        Master master = new Master();
        master.setNombre("Juan");
        master.setUsuario("TiranoMaster");
        master.setPassword("1");

        Master masterDos = new Master();
        masterDos.setNombre("MasterJuan");
        masterDos.setUsuario("OtroMaster");
        masterDos.setPassword("1");

        Master mastertres = new Master();
        mastertres.setNombre("TiranoJuan");
        mastertres.setUsuario("TiranoMaster");
        mastertres.setPassword("1");

        Master masterCuatro = new Master();
        masterCuatro.setNombre("Persona desconocida");
        masterCuatro.setUsuario("MasterCheto");
        masterCuatro.setPassword("1");

        HibernateDao.crearMaster(master);
        HibernateDao.crearMaster(masterDos);
        HibernateDao.crearMaster(mastertres);
        HibernateDao.crearMaster(masterCuatro);
    }

    public static void crearNeo() {

        Jugador hector = new Jugador();
        Personaje neo = new Personaje();
        Caracteristicas c = new Caracteristicas();
        Habilidades habilidades = new Habilidades();

        Hab_armadura ha = new Hab_armadura();
        Hab_armas har = new Hab_armas();
        Hab_generales hg = new Hab_generales();
        Hab_subterfugio hs = new Hab_subterfugio();
        Hab_magicas hm = new Hab_magicas();
        Hab_secundaria hse = new Hab_secundaria();

        Resistencias r = new Resistencias();

        hector.setNombre("Hector");
        hector.setPerfil(Jugador.PERFIL_JUGADOR);
        hector.setNombre_usuario("capitanneo");
        hector.setPassword("porfilip");
        hector.setId_firebase("id de prueba");
        hector.setCumple(new Date(1985, 11, 5));

        c.setFue(100);
        c.setAgi(93);
        c.setCon(99);
        c.setInte(83);
        c.setI(86);
        c.setPre(79);
        c.setApa(77);

        ha.setSa(20);
        ha.setC(10);
        ha.setCe(5);
        ha.setCm(25);
        ha.setCo(25);

        har.setFilo(162);
        har.setContundentes(118);
        har.setDosManos(118);
        har.setArrojadizas(94);
        har.setProyectiles(98);
        har.setAsta(68);
        har.setPelea(122);

        hg.setTrepar(102);
        hg.setMontar(99);
        hg.setNadar(92);
        hg.setRastrear(107);

        hs.setEmboscar(15);
        hs.setAcecharEsconderse(76);
        hs.setAbrirCerraduras(29);
        hs.setDesactivarTrampas(54);

        hm.setUsarObjetos(45);
        hm.setLeerRunas(45);
        hm.setSortilegiosDirgidos(40);
        hm.setSortilegiosBase(14);

        r.setCanalizacion(5);
        r.setEscencia(55);
        r.setMentalismo(5);
        r.setCalor(30);
        r.setFrio(35);
        r.setVenenos(35);
        r.setEnfermedades(35);

        habilidades.setHabArmadura(ha);
        habilidades.setHabArmas(har);
        habilidades.setHabGenerales(hg);
        //habilidades.setHabSecundarias(new Set>habSecundarias);
        habilidades.setHabSubterfugio(hs);
        habilidades.setHabMagicas(hm);
        habilidades.setResistencias(r);

        habilidades.setBonificacionDefensiva(15);
        habilidades.setDesarrolloFisico(143);
        habilidades.setPuntosPoder(42);
        habilidades.setPercepcion(114);

        neo.setJugador(hector);
        neo.setNivel(14);
        neo.setNombre("Neo");
        neo.setAlineamiento("Muy bueno");
        neo.setAltura(180);
        neo.setPeso(107);
        neo.setDiosesAdorados("Tulkas");
        neo.setEdad(28);
        neo.setEstado_civico("Soltero");
        neo.setFamilia("Los Anderson");
        neo.setGenero("Mas");
        neo.setMotivacion("Ser Rey de Gondor");
        neo.setRaza("Dunedan");
        neo.setCaracteristicas(c);
        neo.setHabilidades(habilidades);

        // asignar idiomas
        HashMap<String, Integer> idiomasDeNeo = new HashMap<String, Integer>();
        idiomasDeNeo.put("Adunaico", 5);
        idiomasDeNeo.put("Sindarin", 5);
        idiomasDeNeo.put("Quenya", 5);
        idiomasDeNeo.put("Oestron", 5);
        idiomasDeNeo.put("Lengua Negra", 5);

        Set<Idioma> todosIdiomas = HibernateDao.todosLosIdiomas();

        for (Idioma id : todosIdiomas) {
            if (idiomasDeNeo.containsKey(id.getNombre())) {
                Idioma_desarrollo i_d = new Idioma_desarrollo();
                i_d.setIdioma(id);
                i_d.setValor(idiomasDeNeo.get(id.getNombre()));
                habilidades.aprenderIdioma(i_d);
            }
        }

        HashMap<String, Integer> habSecDeNeo = new HashMap<String, Integer>();
        habSecDeNeo.put("Forrajear", 97);
        habSecDeNeo.put("Comercio", 80);
        habSecDeNeo.put("Frenezi Controlado", 94);
        habSecDeNeo.put("Modo Arcano", 52);
        habSecDeNeo.put("Jugar", 50);
        habSecDeNeo.put("Mitos y Leyendas", 75);
        habSecDeNeo.put("Señales", 40);

        Set<Hab_secundaria> todashabilidadess = HibernateDao.todosLasHabilidadesSecundarias();

        for (Hab_secundaria id : todashabilidadess) {
            if (habSecDeNeo.containsKey(id.getNombre())) {
                Hab_secundaria_desarrollo i_d = new Hab_secundaria_desarrollo();
                i_d.setHab_secundaria(id);
                i_d.setValor(habSecDeNeo.get(id.getNombre()));
                habilidades.aprenderHabiSec(i_d);
            }
        }

        CajaObjetos co = new CajaObjetos();

        ObjetoPortado op = new ObjetoPortado();
        Objeto o = HibernateDao.obtenerObjetoPorId(1l);

        op.setObj(o);
        op.setEnPoder(false);
        op.setPesar(true);
        Info i = new Info();
        i.setSoloMaster(false);
        i.setTexto("Este anillo es una prueba");
        i.setTitulo("pruebaInfo");

        op.addInfo(i);
        neo.setCajaObjetos(co);

        BolsaDeMonedas bdm = new BolsaDeMonedas();
        bdm.setmOro(120);
        bdm.setmBronce(10);
        bdm.setmPlata(500);

        neo.setBolsaDeMonedas(bdm);

        hector.setPj(neo);

        // profesion
        Profesion p = HibernateDao.obtenerProfesionPorNombre("Montaraz");
        ProfesionDesarrollo pd1 = new ProfesionDesarrollo();
        pd1.setProfesion(p);
        pd1.setNivel(14);
        pd1.setExperiencia(54564654);

        Profesion p2 = HibernateDao.obtenerProfesionPorNombre("Exterminador");
        ProfesionDesarrollo pd2 = new ProfesionDesarrollo();
        pd2.setProfesion(p2);
        pd2.setNivel(8);
        pd2.setExperiencia(4564654);

        neo.addprofesion(pd1);
        neo.addprofesion(pd2);

        // STATUS FISICO
        neo.setHorasDeSueño(8);
        StatusFisico sf = new StatusFisico(neo);
        neo.setStatusFisico(sf);
        
        // GUARDADO
        HibernateDao.crearJugador(hector);

    }

    public static void crearIdiomas() {

        Set<Idioma> idiomas = HibernateDao.todosLosIdiomas();
        if (idiomas == null || idiomas.isEmpty()) {
            Idioma adunaico = new Idioma();
            adunaico.setNombre("Adunaico");
            adunaico.setDescripcion("");

            Idioma i2 = new Idioma();
            i2.setNombre("Apysaico");
            i2.setDescripcion("HARADRIMS");

            Idioma i3 = new Idioma();
            i3.setNombre("Atliduk");
            i3.setDescripcion("BEORNIDAS");

            Idioma i4 = new Idioma();
            i4.setNombre("Lengua Negra");
            i4.setDescripcion("Orocos, Olog-hais, Uruk-hais");

            Idioma i5 = new Idioma();
            i5.setNombre("Haradaico");
            i5.setDescripcion("Corsarios, Haradrims, Nùmenoreanos negros, Variags");

            Idioma i6 = new Idioma();
            i6.setNombre("Khuzdul");
            i6.setDescripcion("Enanos, umlis");

            Idioma i7 = new Idioma();
            i7.setNombre("Kuduk");
            i7.setDescripcion("sutil variacion del oestron de los Hobits");

            Idioma i8 = new Idioma();
            i8.setNombre("Labba");
            i8.setDescripcion("Lossoth y umli");

            Idioma i9 = new Idioma();
            i9.setNombre("Logathig");
            i9.setDescripcion("dornwinrin y hombres del este");

            Idioma i10 = new Idioma();
            i10.setNombre("Nahaiduk");
            i10.setDescripcion("beornidas y hombres del bosque");

            Idioma i11 = new Idioma();
            i11.setNombre("Orco");
            i11.setDescripcion("");

            Idioma i12 = new Idioma();
            i12.setNombre("Oestron");
            i12.setDescripcion("lengua màs comun");

            Idioma i13 = new Idioma();
            i13.setNombre("Pukael");
            i13.setDescripcion("Woses");

            Idioma i14 = new Idioma();
            i14.setNombre("Quenya");
            i14.setDescripcion("levemente dunedan, elfos, hombres del bosque y lossoths");

            Idioma i15 = new Idioma();
            i15.setNombre("Rohirrico");
            i15.setDescripcion("Rohirrim");

            Idioma i16 = new Idioma();
            i16.setNombre("Sindarin");
            i16.setDescripcion("Dunedan, elfos y enanos");

            Idioma i17 = new Idioma();
            i17.setNombre("Silvano");
            i17.setDescripcion("Elfos silvanos y sindar");

            Idioma i18 = new Idioma();
            i18.setNombre("Umitico");
            i18.setDescripcion("Umli");

            Idioma i19 = new Idioma();
            i19.setNombre("Varadja");
            i19.setDescripcion("Variags");

            Idioma i20 = new Idioma();
            i20.setNombre("Waildyth");
            i20.setDescripcion("Señas de la naturaleza, beornidas");

            HibernateDao.crearIdioma(adunaico);
            HibernateDao.crearIdioma(i2);
            HibernateDao.crearIdioma(i3);
            HibernateDao.crearIdioma(i4);
            HibernateDao.crearIdioma(i5);
            HibernateDao.crearIdioma(i6);
            HibernateDao.crearIdioma(i7);
            HibernateDao.crearIdioma(i8);
            HibernateDao.crearIdioma(i9);
            HibernateDao.crearIdioma(i10);
            HibernateDao.crearIdioma(i11);
            HibernateDao.crearIdioma(i12);
            HibernateDao.crearIdioma(i13);
            HibernateDao.crearIdioma(i14);
            HibernateDao.crearIdioma(i15);
            HibernateDao.crearIdioma(i16);
            HibernateDao.crearIdioma(i17);
            HibernateDao.crearIdioma(i18);
            HibernateDao.crearIdioma(i19);
            HibernateDao.crearIdioma(i20);
        }
    }

    public static void crearHabilidadesSecundarias() {

        Set<Hab_secundaria> habilidades = HibernateDao.todosLasHabilidadesSecundarias();
        if (habilidades == null || habilidades.isEmpty()) {
            Hab_secundaria h1 = new Hab_secundaria();
            h1.setNombre("Forrajear");
            h1.setModificador(Hab_secundaria.MOD_I);
            h1.setDescripcion("Se usa para encontrar cualquier fuente cercana de agua potable, hierbas o plantas, o animales comestibles");
            h1.setTipo(Hab_secundaria.TIPO_ME);
            HibernateDao.crearHabSecundaria(h1);

            Hab_secundaria h2 = new Hab_secundaria();
            h2.setNombre("Frenezi Controlado");
            h2.setModificador(Hab_secundaria.MOD_XXX);
            h2.setDescripcion("Ante una situacion que enfurece desmedidamente al usuario, éste puede entrar en colera atacando con +50 bo y el doble de puntos de daño, solo cubriendose con la mitad de su bo. Con una tirada de ésta habilidad puede salir de dicho estado");
            h2.setTipo(Hab_secundaria.TIPO_PE);
            HibernateDao.crearHabSecundaria(h2);

            Hab_secundaria h3 = new Hab_secundaria();
            h3.setNombre("Frenezi");
            h3.setModificador(Hab_secundaria.MOD_XXX);
            h3.setDescripcion("Ante una situacion que enfurece desmedidamente al usuario, éste puede entrar en colera atacando con +50 bo y el doble de puntos de daño, solo cubriendose con la mitad de su bo. Con una tirada de ésta habilidad puede salir de dicho estado, mientras se encuentre en el mismo seguira atacando a quien sea, incluso aliados.");
            h3.setTipo(Hab_secundaria.TIPO_PE);
            HibernateDao.crearHabSecundaria(h3);

            Hab_secundaria h4 = new Hab_secundaria();
            h4.setNombre("Jugar");
            h4.setModificador(Hab_secundaria.MOD_I);
            h4.setDescripcion("Conocimiento en juegos de mesa o salon y bono extra jugando cualquier tipo de juego que se encuentre en esta categoria.");
            h4.setTipo(Hab_secundaria.TIPO_ME);
            HibernateDao.crearHabSecundaria(h4);

            Hab_secundaria h5 = new Hab_secundaria();
            h5.setNombre("Mitos y Leyendas");
            h5.setModificador(Hab_secundaria.MOD_XXX);
            h5.setDescripcion("Conocimiento Monstruos y leyendas de conocimiento popular.");
            h5.setTipo(Hab_secundaria.TIPO_PE);
            HibernateDao.crearHabSecundaria(h5);

            Hab_secundaria h6 = new Hab_secundaria();
            h6.setNombre("Magia con Armadura");
            h6.setModificador(Hab_secundaria.MOD_XXX);
            h6.setDescripcion("Habilidad única de paladines, para utilizar magias con una armadura metalica puesta");
            h6.setTipo(Hab_secundaria.TIPO_PE);
            HibernateDao.crearHabSecundaria(h6);

            Hab_secundaria h7 = new Hab_secundaria();
            h7.setNombre("Comercio");
            h7.setModificador(Hab_secundaria.MOD_INTE);
            h7.setDescripcion("Permite tazar el precio o valor de objetos, y tazar objetos.");
            h7.setTipo(Hab_secundaria.TIPO_ME);
            HibernateDao.crearHabSecundaria(h7);

            Hab_secundaria h8 = new Hab_secundaria();
            h8.setNombre("Señales");
            h8.setModificador(Hab_secundaria.MOD_INTE);
            h8.setDescripcion("Capacidad de comnicar ideas .");
            h8.setTipo(Hab_secundaria.TIPO_ME);
            HibernateDao.crearHabSecundaria(h8);

            Hab_secundaria h9 = new Hab_secundaria();
            h9.setNombre("Comercio");
            h9.setModificador(Hab_secundaria.MOD_INTE);
            h9.setDescripcion("Permite tazar el precio o valor de objetos, y tazar objetos.");
            h9.setTipo(Hab_secundaria.TIPO_ME);
            HibernateDao.crearHabSecundaria(h9);

            Hab_secundaria h10 = new Hab_secundaria();
            h10.setNombre("Combo Espada - Espada");
            h10.setModificador(Hab_secundaria.MOD_FUE);
            h10.setDescripcion("BO de habilidad de dos espadas al mismo tiempo.");
            h10.setTipo(Hab_secundaria.TIPO_BO);
            HibernateDao.crearHabSecundaria(h10);

            Hab_secundaria h11 = new Hab_secundaria();
            h11.setNombre("Modo Arcano");
            h11.setModificador(Hab_secundaria.MOD_XXX);
            h11.setDescripcion("Habilidad para convertirse en un Guerrero Arcano");
            h11.setTipo(Hab_secundaria.TIPO_PE);
            HibernateDao.crearHabSecundaria(h11);
        }

    }

    private static void crearObjetos() {

        TipoObjeto to1 = new TipoObjeto();
        to1.setNombre("anillo");
        to1.setDegradado(999999);
        to1.setDurabilidad_stnd(999999);
        to1.setPeso_stnd(1);
        to1.addInfo(true, "Anillo magico", "Coso");
        to1.addInfo(false, "El Anillo en realidad no es magico", "CosoSecreto");

        //HibernateDao.crearTipoDeObjeto(to1);
        Objeto o = new Objeto();
        o.setNombre("Anillo");
        o.setApodo("Anillote");
        o.setTipo(to1);
        o.setDegradado_actual(5);

        HibernateDao.crearObjeto(o);
    }

    private static void crearCampaign() {

        Campaign c = new Campaign();
        c.setNombre("Capitanes de gondor");

        Historia h = new Historia();

        h.setCampaign(c);
        h.setFabula("Esta es una historia de dos capitanes muy valientes que salgan Gondor.");

        Jugador hector = HibernateDao.obtenerJugadorPorId(1l);
        Master tj = HibernateDao.obtenerMasterPorUsuario("TiranMaster");
        if (hector != null) {
            c.addJugador(hector);
            hector.getPj().setCampaign(c);
        }
        c.setMaster(tj);
        HibernateDao.actualizarJugador(hector);
        
        Mundo wo = new Mundo();
        wo.setFecha_rol(new Date());
        wo.setNombre("Tierra media");

        Objeto o = HibernateDao.obtenerObjetoPorId(0l);
        HashSet<Objeto> hs_o = new HashSet<Objeto>();

        wo.setObjetos(hs_o);

        Area a = new Area();
        a.setTipoDeArea(0);
        a.addInfo(true, "Es una area de prueba", "Tipo de area");
        a.addInfo(false, "Es una area de prueba publica", "Tipo de area publica");
        wo.addArea(a);
        c.setMundo(wo);

        c.setHistoria(h);

        HibernateDao.crearCampaign(c);
    }

    private static void crearProfesiones() {
        Profesion p_monta = new Profesion();
        Profesion p_exterminador = new Profesion();
        Profesion p_paladin = new Profesion();
        p_monta.setNombre("Montaraz");
        p_paladin.setNombre("Paladin");
        p_exterminador.setNombre("exterminador");

    }

    private static void cargaCriticos() {
        Critico c = new Critico();
        CodeCritico cc= Constantes.criticoPrueba1;
        c.setId(cc);
        c.setAsaltosYMuere(-1);
        c.setDescripcion(" Golpe en la cabeza, -5pv, aturido 2 asaltos");
        
        Modifier mod = new Modifier();
        mod.setFactor(5);
        mod.setOperador(Modifier.Operador.RESTA);
        mod.setPropiedad(Modifier.Propiedad.ACTIVIDAD);
        c.addcMod(mod);
        
        //c.setModsFisicos();
        ModFisico mf = new ModFisico();
        mf.setHitFisico(ModFisico.HitFisico.CIEGO);
        mf.setHitMental(ModFisico.HitMental.NINGUNO);
        c.addcModFisico(mf);
        
        c.setPerdidaPv(0);
        c.setPv(5);
        c.setAsaltos_aturdido(2);
        c.setRestoActividad(50);

        
        
        Critico c2 = new Critico();
        
        CodeCritico cc2= Constantes.criticoPrueba2;
        c2.setId(cc2);
        c2.setAsaltosYMuere(-1);
        c2.setDescripcion(" Golpe por ahi nomàs, corte profundo -3pv por asalto, aturdido y sin poder parar 2 asaltos, +10 a tu sig golpe");
        c2.setPerdidaPv(-1);
        c2.setPv(5);
        c2.setPerdidaPv(3);
        c2.setAsaltos_aturdido_sin_poder_parar(2);
        c2.setBonoGolpeSiguiente(10);
        c2.setRestoActividad(20);
        
        Critico c3 = new Critico();
        CodeCritico cc3 = Constantes.criticoPrueba19;
        c3.setId_critico(cc3);
        c3.setDescripcion("GOlpe dirigido contra el cuello, que secciona la arteria carotida y la vena yugular. El cuello del adversario se ha roto, y muere despues de una agonia que dura 1 asalto");
        c3.setAsaltosYMuere(1);
        
        
        Critico c4 = new Critico();
        CodeCritico cc4 = Constantes.criticoPrueba18;
        c4.setId_critico(cc4);
        c4.setDescripcion("Cortas la nariz del adversario. Herida leve. +2 puntos de daño y una cicatriz permanente. El adversario pirde 2 puntos de vida por asalto y lucha con un -30. Esta aturdido durante 6 asaltos");
        c4.setAsaltos_aturdido(6);
        c4.setRestoActividad(30);
        c4.setPv(2);
        c4.setPerdidaPv(2);
        ModFisico mf4 = new ModFisico();
        mf4.setHitFisico(ModFisico.HitFisico.PIERDE_NARIZ);
        c4.addcModFisico(mf4);
        
        Critico c5 = new Critico();
        CodeCritico cc5 = Constantes.criticoPrueba17;
        c5.setId_critico(cc5);
        c5.setDescripcion("Amputas la oreja al adversario + 3 pv pierde 3 puntos de vida por asalto con -50, aturdido 3 asaltos, sin poder parar por 1");
        c5.setPv(3);
        c5.setPerdidaPv(3);
        c5.setRestoActividad(50);
        ModFisico mf5 = new ModFisico();
        mf5.setHitFisico(ModFisico.HitFisico.PIERDE_OREJA_DERECHA);
        c5.addcModFisico(mf5);
        
        HibernateDao.crearCritico(c);
        HibernateDao.crearCritico(c2);
        HibernateDao.crearCritico(c3);
        HibernateDao.crearCritico(c4);
        HibernateDao.crearCritico(c5);
    }

}
