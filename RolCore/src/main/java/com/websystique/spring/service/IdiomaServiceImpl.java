package com.websystique.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.IdiomaDao;
import com.websystique.spring.model.caractPj.Idioma;

@Service("idiomaService")
@Transactional
public class IdiomaServiceImpl implements IdiomaService{

	@Autowired
	private IdiomaDao dao;
	
	public void saveIdioma(Idioma idioma) {
		dao.saveIdioma(idioma);
	}

	public List<Idioma> findAllIdiomas() {
		return dao.findAllIdiomas();
	}

	public void deleteIdiomaById(long id) {
		dao.deleteIdiomaById(id);
	}

	public Idioma findById(long id) {
		return dao.findById(id);
	}

	public void updateIdioma(Idioma idioma){
		dao.updateIdioma(idioma);
	}
}
