package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Personaje;
import org.hibernate.Criteria;

public interface PersonajeService {

	void savePersonaje(Personaje personaje);

	Set<Personaje> findAllPersonajes();

	void deletePersonajeById(long id);

	Personaje findById(long id);

	void updatePersonaje(Personaje personaje);
        
        Set<Personaje> findAllPersonajesFromCampaign(long id);        
    
}
