/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.websystique.spring.model.Profesion;
import java.util.HashSet;
import org.springframework.stereotype.Repository;

@Repository("profesionDao")
public class ProfesionDaoImpl extends AbstractDao implements ProfesionDao {

    public void saveProfesion(Profesion profesion) {
        persist(profesion);
    }

    @SuppressWarnings("unchecked")
    public Set<Profesion> findAllProfesions() {
        Criteria criteria = getSession().createCriteria(Profesion.class);
        return new HashSet<Profesion>(criteria.list());
    }

    public void deleteProfesionById(long id) {
        Query query = getSession().createSQLQuery("delete from Profesion where id_profesion = :id");
        query.setLong("id_profesion", id);
        query.executeUpdate();
    }

    public Profesion findById(long id) {
        Criteria criteria = getSession().createCriteria(Profesion.class);
        criteria.add(Restrictions.eq("id_profesion", id));
        return (Profesion) criteria.uniqueResult();
    }

    public void updateProfesion(Profesion profesion) {
        getSession().update(profesion);
    }

    public Profesion findByName(String name) {
        Criteria criteria = getSession().createCriteria(Profesion.class);
        criteria.add(Restrictions.eq("nombre", name));
        return (Profesion) criteria.uniqueResult();
    }

}
