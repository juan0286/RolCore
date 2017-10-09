package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.BonoExp;
import com.websystique.spring.model.Personaje;
import java.util.HashSet;

@Repository("bonoExpDao")
public class BonoExpDaoImpl extends AbstractDao implements BonoExpDao {

    public void saveBonoExp(BonoExp bonoExp) {
        persist(bonoExp);

    }

    @SuppressWarnings("unchecked")
    public Set<BonoExp> findAllBonoExps() {
        Criteria criteria = getSession().createCriteria(BonoExp.class);
        return new HashSet<BonoExp>(criteria.list());
    }

    @SuppressWarnings("unchecked")
    public Set<BonoExp> findAllBonoExpsForPj(Personaje pj) {
        Criteria criteria = getSession().createCriteria(BonoExp.class)
                .add(Restrictions.like("pj", pj));
        return new HashSet<BonoExp>(criteria.list());
    }

    public void deleteBonoExpById(long id) {

        BonoExp be = findById(id);
        getSession().delete(be);

    }

    public BonoExp findById(long id) {
        Criteria criteria = getSession().createCriteria(BonoExp.class);
        criteria.add(Restrictions.eq("id_bonoexp", id));
        return (BonoExp) criteria.uniqueResult();
    }

    public void updateBonoExp(BonoExp bonoExp) {
        getSession().update(bonoExp);
    }

}
