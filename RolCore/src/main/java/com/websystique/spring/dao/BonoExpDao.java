package com.websystique.spring.dao;

import java.util.List;

import com.websystique.spring.model.BonoExp;

public interface BonoExpDao {

	void saveBonoExp(BonoExp bonoExp);
	
	List<BonoExp> findAllBonoExps();
	
	void deleteBonoExpById(long id);
	
	BonoExp findById(long id);
	
	void updateBonoExp(BonoExp bonoExp);
}
