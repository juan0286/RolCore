package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.caractPj.Hab_secundaria;

public interface Hab_secundariaDao {

	void saveHab_secundaria(Hab_secundaria hab_secundaria);
	
	Set<Hab_secundaria> findAllHab_secundarias();
	
	void deleteHab_secundariaById(long id);
	
	Hab_secundaria findById(long id);
	
	void updateHab_secundaria(Hab_secundaria hab_secundaria);
}
