/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

/**
 *
 * @author TiranoJuan
 */
import java.util.Set;

import com.websystique.spring.model.Tempo;

public interface TempoService {

    void saveTempo(Tempo tempo);

    Set<Tempo> findAllTempos();

    void deleteTempoById(long id);

    Tempo findById(long id);

    void updateTempo(Tempo tempo);
    
    void updateTemposCampaign(long upd, long id_campaign);
}
