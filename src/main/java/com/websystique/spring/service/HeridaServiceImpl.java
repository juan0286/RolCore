/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.dao.HeridaDao;
import com.websystique.spring.model.pj.Herida;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TiranoJuan
 */
@Service("heridaService")
@Transactional
public class HeridaServiceImpl implements HeridaService{

@Autowired
private HeridaDao dao;

public void saveHerida(Herida herida) {
dao.saveHerida(herida);
}

public Set<Herida> findAllHeridas() {
return dao.findAllHeridas();
}

public void deleteHeridaById(long id) {
dao.deleteHeridaById(id);
}

public Herida findById(long id) {
return dao.findById(id);
}

public void updateHerida(Herida herida){
dao.updateHerida(herida);
}
}
