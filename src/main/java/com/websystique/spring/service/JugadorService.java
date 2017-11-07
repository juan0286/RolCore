package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Jugador;

public interface JugadorService {

	void saveJugador(Jugador jugador);

	Set<Jugador> findAllJugadors();

	void deleteJugadorById(long id);

	Jugador findById(long id);
        
	Jugador findByIdFirebase(String id);

        Jugador findByName(String name);
	
        Jugador findByUser(String user);   
        
	void updateJugador(Jugador jugador);
}
