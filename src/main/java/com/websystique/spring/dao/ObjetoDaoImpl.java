package com.websystique.spring.dao;

import com.websystique.spring.model.bono.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.objetos.Objeto;
import java.util.HashSet;

@Repository("objetoDao")
public class ObjetoDaoImpl extends AbstractDao implements ObjetoDao{

	public void saveObjeto(Objeto objeto) {
		persist(objeto);
	}

	@SuppressWarnings("unchecked")
	public Set<Objeto> findAllObjetos() {
		Criteria criteria = getSession().createCriteria(Objeto.class);
		return new HashSet<Objeto>(criteria.list());
	}

	public void deleteObjetoByNombre(String nombre) {
		Query query = getSession().createSQLQuery("delete from Objeto where nombre = :nombre");
		query.setString("nombre", nombre);
		query.executeUpdate();
	}

	public void deleteObjetoById(long id) {
		Objeto o = findById(id);
		getSession().delete(o);;
	}

	
	public Objeto findByNombre(String nombre){
		Criteria criteria = getSession().createCriteria(Objeto.class);
		criteria.add(Restrictions.eq("nombre",nombre));
		return (Objeto) criteria.uniqueResult();
	}
	
	public Objeto findById(long id){
		Criteria criteria = getSession().createCriteria(Objeto.class);
		criteria.add(Restrictions.eq("id_objeto",id));
		return (Objeto) criteria.uniqueResult();
	}
	
	public void updateObjeto(Objeto objeto){
		getSession().update(objeto);
	}
	
}
