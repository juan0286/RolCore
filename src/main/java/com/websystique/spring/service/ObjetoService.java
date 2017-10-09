package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.Objeto;

public interface ObjetoService {

	void saveObjeto(Objeto employee);

	Set<Objeto> findAllObjetos();

	void deleteObjetoByNombre(String nombre);

	Objeto findByNombre(String nombre);

	void updateObjeto(Objeto employee);
}
