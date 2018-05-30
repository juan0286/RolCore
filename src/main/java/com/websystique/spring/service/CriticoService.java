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
import com.websystique.spring.model.combate.CodeCritico;
import com.websystique.spring.model.combate.Critico;
import java.util.Set;

public interface CriticoService {

    void saveCritico(Critico critico);

    Set<Critico> findAllCriticos();

    void deleteCriticoById(CodeCritico id);

    Critico findById(CodeCritico id);

    void updateCritico(Critico critico);
}
