package com.websystique.spring.dao;

import com.websystique.spring.model.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Master;
import java.util.HashSet;
import java.util.Iterator;
import org.hibernate.FetchMode;
import org.hibernate.criterion.MatchMode;

@Repository("campaignDao")
public class CampaignDaoImpl extends AbstractDao implements CampaignDao {

    public void saveCampaign(Campaign campaign) {
        persist(campaign);
    }

    /**
     *
     * @param campaign
     * @return
     */
    public long saveCampaignGetId(Campaign campaign) {
        persist(campaign);
        return campaign.getId_campaign();

    }

    @SuppressWarnings("unchecked")
    public Set<Campaign> findAllCampaigns() {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        return new HashSet<Campaign>(criteria.list());
    }

    public void deleteCampaignById(long id) {
        Campaign c = findById(id);
        getSession().delete(c);
    }

    public Campaign findById(long id) {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        criteria.add(Restrictions.eq("id_campaign", id));
        return (Campaign) criteria.uniqueResult();
    }

    public void updateCampaign(Campaign campaign) {
        getSession().update(campaign);
    }

    public Campaign findByName(String name) {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        criteria.add(Restrictions.eq("nombre", name));
        return (Campaign) criteria.uniqueResult();
    }

    public Set<Campaign> findAllCampaignsNombre(String nombre) {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        criteria.add(Restrictions.like("nombre", nombre, MatchMode.ANYWHERE));
        return new HashSet<Campaign>(criteria.list());
    }

    public Set<Campaign> findAllCampaignsMaster(Master m) {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        criteria.add(Restrictions.eq("master", m));
        return new HashSet<Campaign>(criteria.list());
    }

    public Set<Campaign> findAllNewCampaignsPorMaster(String param, long id_j, TypeSearch tipo) {
        Criteria criteria = getSession().createCriteria(Campaign.class);
        if (tipo == TypeSearch.MASTER_NAME) {
            Criteria crit_master = getSession().createCriteria(Master.class);
            crit_master.add(Restrictions.like("usuario", param));
            Master m = (Master) crit_master.uniqueResult();
            criteria.add(Restrictions.eq("master", m));
        }
        if (tipo == TypeSearch.CAMPAIGN_NOMBRE) {
            criteria.add(Restrictions.like("nombre", param, MatchMode.ANYWHERE));
        }
        Criteria crit_jugador = getSession().createCriteria(Jugador.class);
        crit_jugador.add(Restrictions.like("id_jugador", id_j)).setFetchMode("mate", FetchMode.EAGER);
        Jugador j = (Jugador) crit_jugador.uniqueResult();
        HashSet<Campaign> setCampsResp = new HashSet<Campaign>();
        HashSet<Campaign> setCamps = new HashSet<Campaign>(criteria.list());
        lista:
        for (Campaign c : setCamps) {                        
            Set<CampaignAccessRequest> cars = j.getCampaigns();
            boolean guardar= true;
            inJugador:
            for (CampaignAccessRequest car : cars) {
                if (c.equals(car.getCampaign())){                    
                    guardar = false;
                    break inJugador;
                }                
            }
            if (guardar)
                    setCampsResp.add(c);
        }
        return setCampsResp;
    }

}
