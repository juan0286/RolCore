package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.objetos.TipoObjeto;

public interface TipoObjetoService {

	void saveTipoObjeto(TipoObjeto objeto);

	Set<TipoObjeto> findAllTipoObjetos();

	void deleteTipoObjetoByNombre(String nombre);

	TipoObjeto findByNombre(String nombre);

	void updateTipoObjeto(TipoObjeto objeto);
}
