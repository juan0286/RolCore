package com.websystique.spring.dao;

import java.util.List;

import com.websystique.spring.model.Jugador;

public interface JugadorDao {

	void saveJugador(Jugador jugador);
	
	List<Jugador> findAllJugadors();
	
	void deleteJugadorById(long id);
	
	Jugador findById(long id);
	
	void updateJugador(Jugador jugador);
}
