package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.caractPj.Idioma;

@Repository("idiomaDao")
public class IdiomaDaoImpl extends AbstractDao implements IdiomaDao{

	public void saveIdioma(Idioma idioma) {
		persist(idioma);
                
	}

	@SuppressWarnings("unchecked")
	public List<Idioma> findAllIdiomas() {
		Criteria criteria = getSession().createCriteria(Idioma.class);
		return (List<Idioma>) criteria.list();
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
