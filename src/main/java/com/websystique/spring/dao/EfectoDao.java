/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.pj.Efecto;
import java.util.Set;

/**
 *
 * @author TiranoJuan
 */
public interface EfectoDao {

    void saveEfecto(Efecto efecto);

    Set<Efecto> findAllEfectos();

    void deleteEfectoById(long id);

    Efecto findById(long id);

    void updateEfecto(Efecto efecto);
}
