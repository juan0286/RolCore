package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Campaign;

public interface CampaignService {

    void saveCampaign(Campaign campaign);
    
    long saveCampaignGetId(Campaign campaign);

    Set<Campaign> findAllCampaigns();

    void deleteCampaignById(long id);

    Campaign findById(long id);

    void updateCampaign(Campaign campaign);   
    
    public Campaign findByName(String name);
    
    
}
