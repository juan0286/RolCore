package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.model.caractPj.Hab_secundaria;
import com.websystique.spring.dao.Hab_secundariaDao;

@Service("hab_secundariaService")
@Transactional
public class Hab_secundariaServiceImpl implements Hab_secundariaService{

	@Autowired
	private Hab_secundariaDao dao;
	
	public void saveHab_secundaria(Hab_secundaria hab_secundaria) {
		dao.saveHab_secundaria(hab_secundaria);
	}

	public Set<Hab_secundaria> findAllHab_secundarias() {
		return dao.findAllHab_secundarias();
	}

	public void deleteHab_secundariaById(long id) {
		dao.deleteHab_secundariaById(id);
	}

	public Hab_secundaria findById(long id) {
		return dao.findById(id);
	}

	public void updateHab_secundaria(Hab_secundaria hab_secundaria){
		dao.updateHab_secundaria(hab_secundaria);
	}
}
