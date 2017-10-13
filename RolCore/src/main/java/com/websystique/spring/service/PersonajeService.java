package com.websystique.spring.service;

import java.util.List;

import com.websystique.spring.model.Personaje;

public interface PersonajeService {

	void savePersonaje(Personaje personaje);

	List<Personaje> findAllPersonajes();

	void deletePersonajeById(long id);

	Personaje findById(long id);

	void updatePersonaje(Personaje personaje);
}
