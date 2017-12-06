package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.BonoExpDao;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Personaje;

@Service("bonoExpService")
@Transactional
public class BonoExpServiceImpl implements BonoExpService{

	@Autowired
	private BonoExpDao dao;
	
	public void saveBonoExp(BonoExp bonoExp) {
		dao.saveBonoExp(bonoExp);
	}

	public Set<BonoExp> findAllBonoExps() {
		return dao.findAllBonoExps();
	}
        
	public Set<BonoExp> findAllBonoExpsForPj(Personaje pj) {
		return dao.findAllBonoExpsForPj(pj);
	}

	public void deleteBonoExpById(long id) {
		dao.deleteBonoExpById(id);
	}

	public BonoExp findById(long id) {
		return dao.findById(id);
	}

	public void updateBonoExp(BonoExp bonoExp){
		dao.updateBonoExp(bonoExp);
	}
}
