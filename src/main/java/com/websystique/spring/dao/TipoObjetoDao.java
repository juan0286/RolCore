package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.TipoObjeto;

public interface TipoObjetoDao {

	void saveTipoObjeto(TipoObjeto objeto);
	
	Set<TipoObjeto> findAllTipoObjetos();
	
	void deleteTipoObjetoByNombre(String nombre);
	
	TipoObjeto findByNombre(String nombre);
	
	void updateTipoObjeto(TipoObjeto objeto);
}
