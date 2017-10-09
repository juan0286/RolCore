package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.caractPj.Idioma;

public interface IdiomaService {

	void saveIdioma(Idioma idioma);

	Set<Idioma> findAllIdiomas();

	void deleteIdiomaById(long id);

	Idioma findById(long id);

	void updateIdioma(Idioma idioma);
}
