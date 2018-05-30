/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.dao.EfectoDao;
import com.websystique.spring.model.pj.Efecto;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TiranoJuan
 */
@Service("efectoService")
@Transactional
public class EfectoServiceImpl implements EfectoService {

    @Autowired
    private EfectoDao dao;

    public void saveEfecto(Efecto efecto) {
        dao.saveEfecto(efecto);
    }

    public Set<Efecto> findAllEfectos() {
        return dao.findAllEfectos();
    }

    public void deleteEfectoById(long id) {
        dao.deleteEfectoById(id);
    }

    public Efecto findById(long id) {
        return dao.findById(id);
    }

    public void updateEfecto(Efecto efecto) {
        dao.updateEfecto(efecto);
    }
}
