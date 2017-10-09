package com.websystique.spring.dao;

import com.websystique.spring.model.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Campaign;
import java.util.HashSet;

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

}
