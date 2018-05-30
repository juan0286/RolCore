/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.Tempo;
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
@Repository("tempoDao")
public class TempoDaoImpl extends AbstractDao implements TempoDao {

    public void saveTempo(Tempo tempo) {
        persist(tempo);
    }

    @SuppressWarnings("unchecked")
    public Set<Tempo> findAllTempos() {
        Criteria criteria = getSession().createCriteria(Tempo.class);
        return new HashSet<Tempo>(criteria.list());
    }

    public void deleteTempoById(long id) {
        Query query = getSession().createSQLQuery("delete from Tempo where id_tempo = :id");
        query.setLong("id_tempo", id);
        query.executeUpdate();
    }

    public Tempo findById(long id) {
        Criteria criteria = getSession().createCriteria(Tempo.class);
        criteria.add(Restrictions.eq("id_tempo", id));
        return (Tempo) criteria.uniqueResult();
    }

    public void updateTempo(Tempo tempo) {
        getSession().update(tempo);
    }

    public void updateTemposCampaign(long upd, long id_campaign) {
        Query query = getSession().createSQLQuery("UPDATE tempo as t SET transcurso = (transcurso+:upd) WHERE t.campaign_id_campaign = :id");
        query.setLong("upd", upd);
        query.setLong("id", id_campaign);
        query.executeUpdate();
    }

}
