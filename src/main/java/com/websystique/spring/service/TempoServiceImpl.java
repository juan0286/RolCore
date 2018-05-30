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
@Service("tempoService")
@Transactional
public class TempoServiceImpl implements TempoService {
    
    @Autowired
    private TempoDao dao;
    
    public void saveTempo(Tempo tempo) {
        dao.saveTempo(tempo);
    }
    
    public Set<Tempo> findAllTempos() {
        return dao.findAllTempos();
    }
    
    public void deleteTempoById(long id) {
        dao.deleteTempoById(id);
    }
    
    public Tempo findById(long id) {
        return dao.findById(id);
    }
    
    public void updateTempo(Tempo tempo) {
        dao.updateTempo(tempo);
    }
    
    public void updateTemposCampaign(long upd, long id_campaign) {
        dao.updateTemposCampaign(upd, id_campaign);
    }
    
}
