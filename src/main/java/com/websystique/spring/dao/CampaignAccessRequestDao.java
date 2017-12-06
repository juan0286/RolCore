package com.websystique.spring.dao;

import com.websystique.spring.model.Campaign;
import com.websystique.spring.model.CampaignAccessRequest;
import com.websystique.spring.model.Jugador;
import java.util.Set;



public interface CampaignAccessRequestDao {

	void saveCampaignAccessRequest(CampaignAccessRequest campaignAccessRequest);
        
        void saveCampaignAccessRequest(CampaignAccessRequest car, long id_j,long id_c);
	
	Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromPlayer(Jugador j);
	
        Set<CampaignAccessRequest> findAllCampaignAccessRequestsFromCampaign(Campaign c);
	
	void deleteCampaignAccessRequestById(long id);
        
        public void deleteCarComplete(long id_car, long id_j, long id_campaign);
	
	CampaignAccessRequest findById(long id);
        
	void updateCampaignAccessRequest(CampaignAccessRequest campaignAccessRequest);
        
        public void updateStatusCARTo(long id_car, CampaignAccessRequest.estado e);
}
