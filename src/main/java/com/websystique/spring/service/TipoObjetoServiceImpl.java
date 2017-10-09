package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.TipoObjetoDao;
import com.websystique.spring.model.TipoObjeto;

@Service("tipoObjetoService")
@Transactional
public class TipoObjetoServiceImpl implements TipoObjetoService{

	@Autowired
	private TipoObjetoDao dao;
	
	public void saveTipoObjeto(TipoObjeto objeto) {
		dao.saveTipoObjeto(objeto);
	}

	public Set<TipoObjeto> findAllTipoObjetos() {
		return dao.findAllTipoObjetos();
	}

	public void deleteTipoObjetoByNombre(String nombre) {
		dao.deleteTipoObjetoByNombre(nombre);
	}

	public TipoObjeto findByNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	public void updateTipoObjeto(TipoObjeto objeto){
		dao.updateTipoObjeto(objeto);
	}
}
