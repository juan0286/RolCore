package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.Objeto;

public interface ObjetoDao {

	void saveObjeto(Objeto objeto);
	
	Set<Objeto> findAllObjetos();
	
	void deleteObjetoByNombre(String nombre);
	
	Objeto findByNombre(String nombre);
	
	void updateObjeto(Objeto objeto);
}
