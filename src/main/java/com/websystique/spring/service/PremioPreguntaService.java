package com.websystique.spring.service;

import java.util.Set;

import com.websystique.spring.model.messaging.PremioPregunta;

public interface PremioPreguntaService {

    void savePremioPregunta(PremioPregunta premioPregunta);

    Set<PremioPregunta> findAllPremioPreguntas();

    void deletePremioPreguntaById(long id);

    PremioPregunta findById(long id);

    void updatePremioPregunta(PremioPregunta premioPregunta);
}
