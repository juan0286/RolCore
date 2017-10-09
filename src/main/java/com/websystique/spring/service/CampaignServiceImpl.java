package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.CampaignDao;
import com.websystique.spring.model.Campaign;

@Service("campaignService")
@Transactional
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignDao dao;

    public void saveCampaign(Campaign campaign) {
        dao.saveCampaign(campaign);
    }

    public long saveCampaignGetId(Campaign campaign) {
        return dao.saveCampaignGetId(campaign);        
    }

    public Set<Campaign> findAllCampaigns() {
        return dao.findAllCampaigns();
    }

    public void deleteCampaignById(long id) {
        dao.deleteCampaignById(id);
    }

    public Campaign findById(long id) {
        return dao.findById(id);
    }

    public void updateCampaign(Campaign campaign) {
        dao.updateCampaign(campaign);
    }   

    public Campaign findByName(String name) {
        return dao.findByName(name);
    }
}
