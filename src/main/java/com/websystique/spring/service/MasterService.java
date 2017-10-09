package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Master;

public interface MasterService {

	void saveMaster(Master master);

	Set<Master> findAllMasters();

	void deleteMasterById(long id);

	Master findById(long id);

        Master findByName(String name);
	
        Master findByUser(String user);   
        
	void updateMaster(Master master);
}
