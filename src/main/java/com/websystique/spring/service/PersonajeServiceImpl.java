package com.websystique.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.PersonajeDao;
import com.websystique.spring.model.Personaje;

@Service("personajeService")
@Transactional
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	private PersonajeDao dao;
	
	public void savePersonaje(Personaje personaje) {
		dao.savePersonaje(personaje);
	}

	public List<Personaje> findAllPersonajes() {
		return dao.findAllPersonajes();
	}

	public void deletePersonajeById(long id) {
		dao.deletePersonajeById(id);
	}

	public Personaje findById(long id) {
		return dao.findById(id);
	}

	public void updatePersonaje(Personaje personaje){
		dao.updatePersonaje(personaje);
	}
}
