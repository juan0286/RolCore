package com.websystique.spring.dao;

import com.websystique.spring.model.Master;
import java.util.Set;



public interface MasterDao {

	void saveMaster(Master master);
	
	Set<Master> findAllMasters();
	
	void deleteMasterById(long id);
	
	Master findById(long id);
        
	Master findByName(String user);
        
	Master findByUser(String user);
	
	void updateMaster(Master master);
}
