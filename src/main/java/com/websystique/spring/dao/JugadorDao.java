package com.websystique.spring.dao;

import com.websystique.spring.model.Jugador;
import java.util.List;



public interface JugadorDao {

	void saveJugador(Jugador jugador);
	
	List<Jugador> findAllJugadors();
	
	void deleteJugadorById(long id);
	
	Jugador findById(long id);
        
	Jugador findByName(String name);
        
	Jugador findByUser(String user);
	
	void updateJugador(Jugador jugador);
}
