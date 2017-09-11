package com.websystique.spring.dao;

import java.util.List;

import com.websystique.spring.model.Objeto;

public interface ObjetoDao {

	void saveObjeto(Objeto objeto);
	
	List<Objeto> findAllObjetos();
	
	void deleteObjetoByNombre(String nombre);
	
	Objeto findByNombre(String nombre);
	
	void updateObjeto(Objeto objeto);
}
