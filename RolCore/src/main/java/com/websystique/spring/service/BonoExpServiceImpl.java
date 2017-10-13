package com.websystique.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.BonoExpDao;
import com.websystique.spring.model.BonoExp;

@Service("bonoExpService")
@Transactional
public class BonoExpServiceImpl implements BonoExpService{

	@Autowired
	private BonoExpDao dao;
	
	public void saveBonoExp(BonoExp bonoExp) {
		dao.saveBonoExp(bonoExp);
	}

	public List<BonoExp> findAllBonoExps() {
		return dao.findAllBonoExps();
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
