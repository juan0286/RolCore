/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.combate.CodeCritico;
import com.websystique.spring.model.combate.Critico;
import java.util.Set;

/**
 *
 * @author TiranoJuan
 */

public interface CriticoDao {

    void saveCritico(Critico critico);

    Set<Critico> findAllCriticos();

    void deleteCriticoById(CodeCritico id);

    Critico findById(CodeCritico id);

    void updateCritico(Critico critico);
}
