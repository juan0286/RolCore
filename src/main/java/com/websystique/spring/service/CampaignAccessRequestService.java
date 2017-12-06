package com.websystique.spring.service;

import com.websystique.spring.model.Campaign;
import java.util.Set;

import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;

public interface CampaignAccessRequestService {

	void saveCampaignAccessRequest(CampaignAccessRequest campaignAccessRequest);
        
	void saveCampaignAccessRequest(CampaignAccessRequest car, long id_j,long id_c);
	
	Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromPlayer(Jugador j);
	
        Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromCampaign(Campaign c);
	
        public void deleteCarComplete(long id_car, long id_j, long id_campaign);
                
	void deleteCampaignAccessRequestById(long id);
	
	CampaignAccessRequest findById(long id);
        
	void updateCampaignAccessRequest(CampaignAccessRequest campaignAccessRequest);
        
        void updateStatusCARTo(long id_car,CampaignAccessRequest.estado e);
}
