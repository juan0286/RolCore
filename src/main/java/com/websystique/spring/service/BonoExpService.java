package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.BonoExp;
import com.websystique.spring.model.Personaje;

public interface BonoExpService {

	void saveBonoExp(BonoExp bonoExp);

	Set<BonoExp> findAllBonoExps();
        
        Set<BonoExp> findAllBonoExpsForPj(Personaje pj);

	void deleteBonoExpById(long id);

	BonoExp findById(long id);

	void updateBonoExp(BonoExp bonoExp);
}
