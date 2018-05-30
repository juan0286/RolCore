package com.websystique.spring.dao;

import com.websystique.spring.dao.AbstractDao;
import com.websystique.spring.dao.HeridaDao;
import com.websystique.spring.model.pj.Herida;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Repository("heridaDao")
public class HeridaDaoImpl extends AbstractDao implements HeridaDao {

    public void saveHerida(Herida herida) {
        persist(herida);
    }

    @SuppressWarnings("unchecked")
    public Set<Herida> findAllHeridas() {
        Criteria criteria = getSession().createCriteria(Herida.class);
        return new HashSet<Herida>(criteria.list());
    }

    public void deleteHeridaById(long id) {        
        Herida h = findById(id);
        getSession().delete(h);
    }

    public Herida findById(long id) {
        Criteria criteria = getSession().createCriteria(Herida.class);
        criteria.add(Restrictions.eq("id_herida", id));
        return (Herida) criteria.uniqueResult();
    }

    public void updateHerida(Herida herida) {
        getSession().update(herida);
    }

}
