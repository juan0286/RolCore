package com.websystique.spring.dao;

import java.util.List;

import com.websystique.spring.model.Personaje;

public interface PersonajeDao {

	void savePersonaje(Personaje personaje);
	
	List<Personaje> findAllPersonajes();
	
	void deletePersonajeById(long id);
	
	Personaje findById(long id);
	
	void updatePersonaje(Personaje personaje);
}
