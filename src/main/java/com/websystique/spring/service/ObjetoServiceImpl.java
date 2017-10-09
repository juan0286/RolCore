package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.ObjetoDao;
import com.websystique.spring.model.Objeto;

@Service("objetoService")
@Transactional
public class ObjetoServiceImpl implements ObjetoService{

	@Autowired
	private ObjetoDao dao;
	
	public void saveObjeto(Objeto objeto) {
		dao.saveObjeto(objeto);
	}

	public Set<Objeto> findAllObjetos() {
		return dao.findAllObjetos();
	}

	public void deleteObjetoByNombre(String nombre) {
		dao.deleteObjetoByNombre(nombre);
	}

	public Objeto findByNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	public void updateObjeto(Objeto objeto){
		dao.updateObjeto(objeto);
	}
}
