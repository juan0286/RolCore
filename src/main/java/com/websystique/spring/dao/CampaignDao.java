package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.Jugador;
import com.websystique.spring.model.Master;

public interface CampaignDao {

        public static enum TypeSearch{MASTER_NAME,CAMPAIGN_NOMBRE};        
        
	void saveCampaign(Campaign campaign);
        
	long saveCampaignGetId(Campaign campaign);
	
	Set<Campaign> findAllCampaigns();
        
        Set<Campaign> findAllCampaignsNombre(String nombre);
    
        Set<Campaign> findAllCampaignsMaster(Master m);
        
        Set<Campaign> findAllNewCampaignsPorMaster(String param,long id_j, TypeSearch tipo);
    
	void deleteCampaignById(long id);
	
	Campaign findById(long id);     
        
        Campaign findByName(String name);
	
	void updateCampaign(Campaign campaign);    
}
