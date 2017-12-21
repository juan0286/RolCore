package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.messaging.PremioPregunta;

public interface PremioPreguntaDao {

	void savePremioPregunta(PremioPregunta premioPregunta);
	
	Set<PremioPregunta> findAllPremioPreguntas();
	
	void deletePremioPreguntaById(long id);
	
	PremioPregunta findById(long id);
	
	void updatePremioPregunta(PremioPregunta premioPregunta);
}
