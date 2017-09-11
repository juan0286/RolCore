package com.websystique.spring.service;

import java.util.List;

import com.websystique.spring.model.TipoObjeto;

public interface TipoObjetoService {

	void saveTipoObjeto(TipoObjeto objeto);

	List<TipoObjeto> findAllTipoObjetos();

	void deleteTipoObjetoByNombre(String nombre);

	TipoObjeto findByNombre(String nombre);

	void updateTipoObjeto(TipoObjeto objeto);
}
