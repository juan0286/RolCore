package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Personaje;

public interface PersonajeService {

	void savePersonaje(Personaje personaje);

	Set<Personaje> findAllPersonajes();

	void deletePersonajeById(long id);

	Personaje findById(long id);

	void updatePersonaje(Personaje personaje);
}
