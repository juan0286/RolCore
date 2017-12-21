package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Jugador;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.exception.ConstraintViolationException;

@Repository("jugadorDao")
public class JugadorDaoImpl extends AbstractDao implements JugadorDao {

    private static final Logger LOGGER = Logger.getLogger(JugadorDaoImpl.class.getName());

    public void saveJugador(Jugador jugador) {
        try {
            persist(jugador);
        } catch (ConstraintViolationException cve) {
            try {
                if (getSession().getTransaction().isActive()) {
                    getSession().getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }

        } catch (RuntimeException ex) {
            try {
                if (getSession().getTransaction().isActive()) {
                    getSession().getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (getSession().getTransaction().isActive()) {
                    getSession().getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }

    }

    @SuppressWarnings("unchecked")
    public Set<Jugador> findAllJugadors() {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        return new HashSet<Jugador>(criteria.list());
    }

    public void deleteJugadorById(long id) {
        Jugador j = findById(id);
        getSession().delete(j);
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

    public Jugador findByIdFirebase(String id) {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        criteria.add(Restrictions.eq("id_firebase", id));
        return (Jugador) criteria.uniqueResult();
    }

}
