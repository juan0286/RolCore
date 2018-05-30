/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.pj.Efecto;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TiranoJuan
 */
@Repository("efectoDao")
public class EfectoDaoImpl extends AbstractDao implements EfectoDao {

    public void saveEfecto(Efecto efecto) {
        persist(efecto);
    }

    @SuppressWarnings("unchecked")
    public Set<Efecto> findAllEfectos() {
        Criteria criteria = getSession().createCriteria(Efecto.class);
        return new HashSet<Efecto>(criteria.list());
    }

    public void deleteEfectoById(long id) {
        Query query = getSession().createSQLQuery("delete from Efecto where id_efecto = :id_efecto");
        query.setLong("id_efecto", id);
        query.executeUpdate();
    }

    public Efecto findById(long id) {
        Criteria criteria = getSession().createCriteria(Efecto.class);
        criteria.add(Restrictions.eq("id_efecto", id));
        return (Efecto) criteria.uniqueResult();
    }

    public void updateEfecto(Efecto efecto) {
        getSession().update(efecto);
    }

}
