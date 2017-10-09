package com.websystique.spring.dao;

import com.websystique.spring.model.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.caractPj.Idioma;
import java.util.HashSet;

@Repository("idiomaDao")
public class IdiomaDaoImpl extends AbstractDao implements IdiomaDao{

	public void saveIdioma(Idioma idioma) {
		persist(idioma);
                
	}

	@SuppressWarnings("unchecked")
	public Set<Idioma> findAllIdiomas() {
		Criteria criteria = getSession().createCriteria(Idioma.class);
		return new HashSet<Idioma>(criteria.list());
	}

	public void deleteIdiomaById(long id) {
		Query query = getSession().createSQLQuery("delete from Idioma where id_idioma = :id");
		query.setLong("id_idioma", id);
		query.executeUpdate();
	}

	
	public Idioma findById(long id){
		Criteria criteria = getSession().createCriteria(Idioma.class);
		criteria.add(Restrictions.eq("id_idioma",id));
		return (Idioma) criteria.uniqueResult();
	}
	
	public void updateIdioma(Idioma idioma){
		getSession().update(idioma);
	}
	
}
