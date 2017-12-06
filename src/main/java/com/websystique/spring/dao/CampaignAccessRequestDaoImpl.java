/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TiranoJuan
 */
@Repository("campaignAccessRequestDao")
public class CampaignAccessRequestDaoImpl extends AbstractDao implements CampaignAccessRequestDao {
    
    private static final Logger LOGGER = Logger.getLogger(CampaignAccessRequestDaoImpl.class.getName());
    
    public void saveCampaignAccessRequest(CampaignAccessRequest c) {
        Criteria criteria = getSession().createCriteria(Jugador.class);
        persist(c);        
    }
    
    public void saveCampaignAccessRequest(CampaignAccessRequest car, long id_j, long id_c) {
        Criteria criteriaC = getSession().createCriteria(Campaign.class);
        criteriaC.add(Restrictions.eq("id_campaign", id_c));
        Criteria criteriaJ = getSession().createCriteria(Jugador.class);
        criteriaJ.add(Restrictions.eq("id_jugador", id_j));
        Campaign c = (Campaign) criteriaC.uniqueResult();
        Jugador j = (Jugador) criteriaJ.uniqueResult();
        car.setCampaign(c);
        car.setJugador(j);
        persist(car);        
        c.addCar(car);
        j.addcARequest(car);
        getSession().update(c);
        getSession().update(j);
        LOGGER.log(Level.WARNING, "Guardado nuevo car " + car.toString());
    }
    
    public void deleteCarComplete(long id_car, long id_j, long id_campaign) {
        try {
            Criteria criteriaC = getSession().createCriteria(Campaign.class);
            criteriaC.add(Restrictions.eq("id_campaign", id_campaign));
            Criteria criteriaJ = getSession().createCriteria(Jugador.class);
            criteriaJ.add(Restrictions.eq("id_jugador", id_j));
            Criteria crit_car = getSession().createCriteria(CampaignAccessRequest.class);
            crit_car.add(Restrictions.eq("id_car", id_car));
            Campaign c = (Campaign) criteriaC.uniqueResult();
            Jugador j = (Jugador) criteriaJ.uniqueResult();
            CampaignAccessRequest car = (CampaignAccessRequest) crit_car.uniqueResult();
            j.getCampaigns().remove(car);
            c.getCars().remove(car);
            getSession().update(c);
            getSession().update(j);
            car.setCampaign(null);
            car.setJugador(null);
            updateCampaignAccessRequest(car);
            deleteCampaignAccessRequestById(id_car);
            LOGGER.log(Level.FINE, "Anulado car con ID" + id_car);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Fallo borrado nuevo car " + id_car + " error" + ex);
        }        
        
    }
    
    public Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromPlayer(Jugador j) {
        Criteria criteria = getSession().createCriteria(CampaignAccessRequest.class).add(Restrictions.eq("jugador", j));
        return new HashSet<CampaignAccessRequest>(criteria.list());
    }
    
    public Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromCampaign(Campaign c) {
        Criteria criteria = getSession().createCriteria(CampaignAccessRequest.class).add(Restrictions.eq("campaign", c));
        return new HashSet<CampaignAccessRequest>(criteria.list());
    }
    
    public void deleteCampaignAccessRequestById(long id) {
        CampaignAccessRequest c = findById(id);
        getSession().delete(c);;
    }
    
    public CampaignAccessRequest findById(long id) {
        Criteria criteria = getSession().createCriteria(CampaignAccessRequest.class);
        criteria.add(Restrictions.eq("id_car", id));
        return (CampaignAccessRequest) criteria.uniqueResult();
    }
    
    public void updateCampaignAccessRequest(CampaignAccessRequest c) {
        getSession().update(c);
    }
    
    public void updateStatusCARTo(long id_car, CampaignAccessRequest.estado e){
        CampaignAccessRequest c = findById(id_car);
        c.setStatus(e);
        getSession().update(c);
    }
}
