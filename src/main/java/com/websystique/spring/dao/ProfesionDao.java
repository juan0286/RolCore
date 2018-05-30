package com.websystique.spring.dao;

import java.util.Set;

import com.websystique.spring.model.Profesion;

public interface ProfesionDao {

    void saveProfesion(Profesion profesion);

    Set<Profesion> findAllProfesions();

    void deleteProfesionById(long id);

    Profesion findById(long id);
    
    Profesion findByName(String name);

    void updateProfesion(Profesion profesion);
}
