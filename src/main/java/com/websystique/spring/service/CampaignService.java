package com.websystique.spring.service;

import com.websystique.spring.dao.CampaignDao;
import java.util.Set;

import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.Master;
import com.websystique.spring.model.Personaje;

public interface CampaignService {

    void saveCampaign(Campaign campaign);
    
    long saveCampaignGetId(Campaign campaign);

    Set<Campaign> findAllCampaigns();
    
    Set<Campaign> findAllCampaignsNombre(String nombre);
    
    Set<Campaign> findAllCampaignsMaster(Master m);
    
    Set<Campaign> findAllNewCampaignsPorMaster(String param,long id_j, CampaignDao.TypeSearch tipo);

    void deleteCampaignById(long id);

    Campaign findById(long id);

    void updateCampaign(Campaign campaign);   
    
    public Campaign findByName(String name);
    
    
}
