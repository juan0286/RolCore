package com.websystique.spring.dao;

import com.websystique.spring.model.bono.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.caractPj.Hab_secundaria;
import java.util.HashSet;

@Repository("hab_secundariaDao")
public class Hab_secundariaDaoImpl extends AbstractDao implements Hab_secundariaDao{

	public void saveHab_secundaria(Hab_secundaria hab_secundaria) {
		persist(hab_secundaria);
                
	}

	@SuppressWarnings("unchecked")
	public Set<Hab_secundaria> findAllHab_secundarias() {
		Criteria criteria = getSession().createCriteria(Hab_secundaria.class);
		return new HashSet<Hab_secundaria>(criteria.list());
	}

	public void deleteHab_secundariaById(long id) {
		Query query = getSession().createSQLQuery("delete from Hab_secundaria where id_hab_secundaria = :id");
		query.setLong("id_hab_secundaria", id);
		query.executeUpdate();
	}

	
	public Hab_secundaria findById(long id){
		Criteria criteria = getSession().createCriteria(Hab_secundaria.class);
		criteria.add(Restrictions.eq("id_hab_secundaria",id));
		return (Hab_secundaria) criteria.uniqueResult();
	}
	
	public void updateHab_secundaria(Hab_secundaria hab_secundaria){
		getSession().update(hab_secundaria);
	}
	
}
