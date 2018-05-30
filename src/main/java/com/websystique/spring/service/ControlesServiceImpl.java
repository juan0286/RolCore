package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.BonoExpDao;
import com.websystique.spring.dao.ControlesDao;
import com.websystique.spring.model.bono.BonoExp;
import com.websystique.spring.model.Personaje;

@Service("controlesService")
@Transactional
public class ControlesServiceImpl implements ControlesService{

	@Autowired
	private ControlesDao dao;

    public int actividadActualPj(Personaje pj) {
        return dao.actividadActualPj(pj);
    }
	
	
}
