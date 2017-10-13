package com.websystique.spring.service;

import java.util.List;

import com.websystique.spring.model.Jugador;

public interface JugadorService {

	void saveJugador(Jugador jugador);

	List<Jugador> findAllJugadors();

	void deleteJugadorById(long id);

	Jugador findById(long id);

	void updateJugador(Jugador jugador);
}
