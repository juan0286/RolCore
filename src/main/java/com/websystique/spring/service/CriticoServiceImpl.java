/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.service;

import com.websystique.spring.model.combate.Critico;
import com.websystique.spring.dao.CriticoDao;
import com.websystique.spring.model.combate.CodeCritico;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TiranoJuan
 */
@Service("criticoService")
@Transactional
public class CriticoServiceImpl implements CriticoService {

    @Autowired
    private CriticoDao dao;

    public void saveCritico(Critico critico) {
        dao.saveCritico(critico);
    }

    public Set<Critico> findAllCriticos() {
        return dao.findAllCriticos();
    }

    public void deleteCriticoById(CodeCritico id) {
        dao.deleteCriticoById(id);
    }

    public Critico findById(CodeCritico id) {
        return dao.findById(id);
    }

    public void updateCritico(Critico critico) {
        dao.updateCritico(critico);
    }
}
