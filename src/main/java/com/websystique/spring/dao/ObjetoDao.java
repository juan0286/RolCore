package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.objetos.Objeto;

public interface ObjetoDao {

	void saveObjeto(Objeto objeto);
	
	Set<Objeto> findAllObjetos();
	
	void deleteObjetoByNombre(String nombre);
        
	void deleteObjetoById(long id);
	
	Objeto findByNombre(String nombre);
        
	Objeto findById(long id);
	
	void updateObjeto(Objeto objeto);
}
