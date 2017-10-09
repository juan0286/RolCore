package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import java.util.HashSet;

@Repository("jugadorDao")
public class JugadorDaoImpl extends AbstractDao implements JugadorDao {

    public void saveJugador(Jugador jugador) {
        persist(jugador);
    }

    @SuppressWarnings("unchecked")
    public Set<Jugador> findAllJugadors() {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        return  new HashSet<Jugador>(criteria.list());
    }

    public void deleteJugadorById(long id) {
        Query query = getSession().createSQLQuery("delete from Jugador where id_jugador = :id");
        query.setLong("id_jugador", id);
        query.executeUpdate();
    }

    public Jugador findById(long id) {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        criteria.add(Restrictions.eq("id_jugador", id));
        return (Jugador) criteria.uniqueResult();
    }

    public void updateJugador(Jugador jugador) {
        getSession().update(jugador);
    }

    public Jugador findByUser(String name) {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        criteria.add(Restrictions.eq("nombre_usuario", name));
        return (Jugador) criteria.uniqueResult();
    }

    public Jugador findByName(String name) {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        criteria.add(Restrictions.eq("nombre", name));
        return (Jugador) criteria.uniqueResult();
    }

}
