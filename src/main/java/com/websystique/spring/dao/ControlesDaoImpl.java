/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.HibernateDao;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.pj.Efecto;
import com.websystique.spring.model.pj.Herida;
import com.websystique.spring.model.pj.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TiranoJuan
 */
@Repository("controlesDao")
public class ControlesDaoImpl extends AbstractDao implements ControlesDao {

    private static final Logger LOGGER = Logger.getLogger(ControlesDaoImpl.class.getName());

    public int actividadActualPj(Personaje pj) {
        Personaje pj2 = new Personaje();
        //Herida h = pj2.getStatusFisico().getHeridas().iterator().next();

        // + "        sf1.asaltos_aturdido as aturdido\n"
//        Query query = getSession().createSQLQuery("select\n"
//                + "        sf1.asaltos_aturdido_sin_poder_parar as aturdidoSP"
//                + ", sf1.asaltos_aturdido as aturdido\n"
//                + ", sf1.asaltos_obligado_a_Parar as oAParar\n"
//                + "from\n"
//                + "        Personaje p \n"
//                + "left outer join\n"
//                + "        StatusFisico sf1 \n"
//                + "            on p.ID_SF=sf1.id_sf \n"
//                + "            where\n"
//                + "        p.id_pj=:id");
        Query query1 = getSession().createSQLQuery("select\n"
                + "        SUM(mo.factor) as valor  \n"
                + "    from\n"
                + "        Herida h          \n"
                + "    inner join\n"
                + "        StatusFisico_Herida sfh              \n"
                + "            on sfh.heridas_id_herida=h.id_herida      \n"
                + "    WHERE        \n"
                + "        h.estadoHerida=0\n"
                + "        AND         \n"
                + "        sfh.StatusFisico_id_sf=:id");

        Query query2 = getSession().createSQLQuery("select\n"
                + "     SUM(mo.factor) as valor, mo.operador as op, "
                + "         mo.propiedad as pro,"
                + "         sfh.StatusFisico_id_sf as idsf  \n"
                + "    from\n"
                + "        Modifier mo      \n"
                + "    inner join\n"
                + "        herida_modifier hm              \n"
                + "            on mo.id_mod=hm.mods_id_mod      \n"
                + "    inner join\n"
                + "        Herida h              \n"
                + "            on h.id_herida=hm.Herida_id_herida      \n"
                + "    inner join\n"
                + "        StatusFisico_Herida sfh              \n"
                + "            on sfh.heridas_id_herida=h.id_herida      \n"
                + "    GROUP BY mo.operador\n"
                + "    HAVING\n"
                + "        mo.propiedad=37 \n"
                + "        AND         \n"
                + "        idsf=:id");

        query1.setLong("id", pj.getId_pj());
        //query.setLong("id", pj.getStatusFisico().getId_sf());

        Double d = (Double) query1.uniqueResult();
        //Integer n = d.intValue();
        //Integer datos = (Integer) query.uniqueResult();
        List<Object[]> listDatos = query2.list();
        for (Object[] datos : listDatos) {
//        System.out.println("Actividad: " + n);
            System.out.println("Aturdido: " + datos[1]);
            System.out.println("Obligado a Parar: " + datos[2]);
        }
        //n = datos[0] - datos[1] * datos[3] / datos[4];
        return 5;
    }

    public int aturdimientoActualPj(Personaje pj) {
        Personaje pj2 = new Personaje();
        //pj2.getStatusFisico().getAsaltos_aturdido()

        try {
            Query query = getSession().createSQLQuery("SELECT p.statusFisico.Asaltos_aturdido atu FROM Personaje p");
            //Query query = getSession().createSQLQuery("SELECT SUM(p.nivel) FROM Personaje p");
            //   Query query = getSession().createSQLQuery("SELECT SUM(p.efecto.mod.factor) FROM Personaje p");
            //pj.getStatusFisico().getHeridas().iterator().next().getMods().iterator().next().getFactor();
            List<Object[]> listDatos = query.list();
            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "--" + datos[1]);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return 5;
    }

    public void updatePersonaje(Personaje personaje) {
        getSession().update(personaje);
    }
}
