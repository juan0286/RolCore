package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.websystique.spring.model.messaging.PremioPregunta;
import java.util.HashSet;

@Repository("premioPreguntaDao")
public class PremioPreguntaDaoImpl extends AbstractDao implements PremioPreguntaDao{

	public void savePremioPregunta(PremioPregunta premioPregunta) {
		persist(premioPregunta);
	}

	@SuppressWarnings("unchecked")
	public Set<PremioPregunta> findAllPremioPreguntas() {
		Criteria criteria = getSession().createCriteria(PremioPregunta.class);
		return  new HashSet<PremioPregunta>(criteria.list());
	}

	public void deletePremioPreguntaById(long id) {
		Query query = getSession().createSQLQuery("delete from PremioPregunta where id_pp = :id");
		query.setLong("id_premioPregunta", id);
		query.executeUpdate();
	}

	
	public PremioPregunta findById(long id){
		Criteria criteria = getSession().createCriteria(PremioPregunta.class);
		criteria.add(Restrictions.eq("id_pp",id));
		return (PremioPregunta) criteria.uniqueResult();
	}
	
	public void updatePremioPregunta(PremioPregunta premioPregunta){
		getSession().update(premioPregunta);
	}
    
	
}
