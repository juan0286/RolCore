package com.websystique.spring.service;

import java.util.List;

import com.websystique.spring.model.caractPj.Idioma;

public interface IdiomaService {

	void saveIdioma(Idioma idioma);

	List<Idioma> findAllIdiomas();

	void deleteIdiomaById(long id);

	Idioma findById(long id);

	void updateIdioma(Idioma idioma);
}
