/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.pj.Herida;

/**
 *
 * @author TiranoJuan
 */
;

public interface HeridaService {

    void saveHerida(Herida herida);

    Set<Herida> findAllHeridas();

    void deleteHeridaById(long id);

    Herida findById(long id);

    void updateHerida(Herida herida);
}
