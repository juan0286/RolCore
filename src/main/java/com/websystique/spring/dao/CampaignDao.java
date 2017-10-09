package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.Campaign;

public interface CampaignDao {

	void saveCampaign(Campaign campaign);
        
	long saveCampaignGetId(Campaign campaign);
	
	Set<Campaign> findAllCampaigns();
	
	void deleteCampaignById(long id);
	
	Campaign findById(long id);     
        
        Campaign findByName(String name);
	
	void updateCampaign(Campaign campaign);    
}
