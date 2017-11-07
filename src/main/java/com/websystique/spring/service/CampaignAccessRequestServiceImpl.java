package com.websystique.spring.service;

import com.websystique.spring.dao.CampaignAccessRequestDao;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.CampaignDao;
import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;

@Service("campaignAccessRequestService")
@Transactional
public class CampaignAccessRequestServiceImpl implements CampaignAccessRequestService {

    @Autowired
    private CampaignAccessRequestDao dao;

    public void saveCampaignAccessRequest(CampaignAccessRequest campaign) {
        dao.saveCampaignAccessRequest(campaign);
    }
    
    public void saveCampaignAccessRequest(CampaignAccessRequest car, long id_j, long id_c) {
        dao.saveCampaignAccessRequest(car, id_j, id_c);
    }
    
    public Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromPlayer(Jugador j){
        return dao.findAllCampaignAccessRequestsFromPlayer(j);
    }

    public Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromCampaign(Campaign c){
        return dao.findAllCampaignAccessRequestsFromCampaign(c);
    }

    public void deleteCampaignAccessRequestById(long id) {
        dao.deleteCampaignAccessRequestById(id);
    }

    public CampaignAccessRequest findById(long id) {
        return dao.findById(id);
    }

    public void updateCampaignAccessRequest(CampaignAccessRequest campaign) {
        dao.updateCampaignAccessRequest(campaign);
    }   

    

    
}
