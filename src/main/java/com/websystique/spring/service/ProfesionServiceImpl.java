/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.dao.ProfesionDao;
import com.websystique.spring.model.Profesion;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TiranoJuan
 */
@Service("profesionService")
@Transactional
public class ProfesionServiceImpl implements ProfesionService {

    @Autowired
    private ProfesionDao dao;

    public void saveProfesion(Profesion profesion) {
        dao.saveProfesion(profesion);
    }

    public Set<Profesion> findAllProfesions() {
        return dao.findAllProfesions();
    }

    public void deleteProfesionById(long id) {
        dao.deleteProfesionById(id);
    }

    public Profesion findById(long id) {
        return dao.findById(id);
    }
    
    public Profesion findByName(String name) {
        return dao.findByName(name);
    }

    public void updateProfesion(Profesion profesion) {
        dao.updateProfesion(profesion);
    }
}
