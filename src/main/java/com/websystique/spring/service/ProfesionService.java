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
import com.websystique.spring.model.Profesion;

public interface ProfesionService {

    void saveProfesion(Profesion profesion);

    Set<Profesion> findAllProfesions();

    void deleteProfesionById(long id);

    Profesion findById(long id);
    
    Profesion findByName(String name);

    void updateProfesion(Profesion profesion);
}
