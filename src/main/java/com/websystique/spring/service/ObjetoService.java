package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.objetos.Objeto;

public interface ObjetoService {

	void saveObjeto(Objeto employee);

	Set<Objeto> findAllObjetos();

	void deleteObjetoByNombre(String nombre);
        
	void deleteObjetoById(long id);

	Objeto findByNombre(String nombre);
        
	Objeto findById(long id);

	void updateObjeto(Objeto employee);
}
