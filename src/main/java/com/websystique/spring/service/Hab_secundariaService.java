package com.websystique.spring.service;

import java.util.List;

import com.websystique.spring.model.caractPj.Hab_secundaria;

public interface Hab_secundariaService {

	void saveHab_secundaria(Hab_secundaria hab_secundaria);

	List<Hab_secundaria> findAllHab_secundarias();

	void deleteHab_secundariaById(long id);

	Hab_secundaria findById(long id);

	void updateHab_secundaria(Hab_secundaria hab_secundaria);
}
