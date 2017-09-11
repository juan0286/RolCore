package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.BonoExp;

@Repository("bonoExpDao")
public class BonoExpDaoImpl extends AbstractDao implements BonoExpDao{

	public void saveBonoExp(BonoExp bonoExp) {
		persist(bonoExp);
                
	}

	@SuppressWarnings("unchecked")
	public List<BonoExp> findAllBonoExps() {
		Criteria criteria = getSession().createCriteria(BonoExp.class);
		return (List<BonoExp>) criteria.list();
	}

	public void deleteBonoExpById(long id) {
		Query query = getSession().createSQLQuery("delete from BonoExp where id_bonoexp = :id");
		query.setLong("id_bonoexp", id);
		query.executeUpdate();
	}

	
	public BonoExp findById(long id){
		Criteria criteria = getSession().createCriteria(BonoExp.class);
		criteria.add(Restrictions.eq("id_bonoexp",id));
		return (BonoExp) criteria.uniqueResult();
	}
	
	public void updateBonoExp(BonoExp bonoExp){
		getSession().update(bonoExp);
	}
	
}
