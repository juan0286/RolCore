/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.dao.TempoDao;
import com.websystique.spring.model.Tempo;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TiranoJuan
 */
@Service("tempoServiceDos")
@Transactional
public class TempoServiceImplDos implements IService {
    
    @Autowired
    private TempoDao dao;

    @Override
    public void save(Object o) {
        dao.saveTempo((Tempo) o);
    }

    @Override
    public Set<Object> findAllFromMundo(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        dao.deleteTempoById(id);
    }

    @Override
    public Object findById(long id) {
        return dao.findById(id);
    }

    @Override
    public void update(Object o) {
        dao.updateTempo((Tempo) o);
    }
    
    
}
