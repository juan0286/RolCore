package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Jugador;

@Repository("jugadorDao")
public class JugadorDaoImpl extends AbstractDao implements JugadorDao{

	public void saveJugador(Jugador jugador) {
		persist(jugador);
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> findAllJugadors() {
		Criteria criteria = getSession().createCriteria(Jugador.class);
		return (List<Jugador>) criteria.list();
	}

	public void deleteJugadorById(long id) {
		Query query = getSession().createSQLQuery("delete from Jugador where id_jugador = :id");
		query.setLong("id_jugador", id);
		query.executeUpdate();
	}

	
	public Jugador findById(long id){
		Criteria criteria = getSession().createCriteria(Jugador.class);
		criteria.add(Restrictions.eq("id_jugador",id));
		return (Jugador) criteria.uniqueResult();
	}
	
	public void updateJugador(Jugador jugador){
		getSession().update(jugador);
	}
	
}
