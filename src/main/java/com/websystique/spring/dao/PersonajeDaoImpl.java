package com.websystique.spring.dao;

import com.websystique.spring.model.Campaign;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import java.util.HashSet;

@Repository("personajeDao")
public class PersonajeDaoImpl extends AbstractDao implements PersonajeDao {

    public void savePersonaje(Personaje personaje) {
        persist(personaje);
    }

    @SuppressWarnings("unchecked")
    public Set<Personaje> findAllPersonajes() {
        Criteria criteria = getSession().createCriteria(Personaje.class);
        return new HashSet<Personaje>(criteria.list());
    }

    public void deletePersonajeById(long id) {
        Query query = getSession().createSQLQuery("delete from Personaje where id_pj = :id");
        query.setLong("id_personaje", id);
        query.executeUpdate();
    }

    public Personaje findById(long id) {
        Criteria criteria = getSession().createCriteria(Personaje.class);
        criteria.add(Restrictions.eq("id_pj", id));
        return (Personaje) criteria.uniqueResult();
    }

    public void updatePersonaje(Personaje personaje) {
        getSession().update(personaje);
    }

    public Set<Personaje> findAllPersonajesFromCampaign(long id) {
        
        Criteria criteria = getSession().createCriteria(Campaign.class);
        criteria.add(Restrictions.eq("id_campaign", id));
        Campaign c = (Campaign) criteria.uniqueResult();
        
        criteria = getSession().createCriteria(Personaje.class);
        criteria.add(Restrictions.eq("campaign", c));
        return new HashSet<Personaje>(criteria.list());
    }

}
