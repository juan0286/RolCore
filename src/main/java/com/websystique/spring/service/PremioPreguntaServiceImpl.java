package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.PersonajeDao;
import com.websystique.spring.dao.PremioPreguntaDao;
import com.websystique.spring.model.Personaje;
import com.websystique.spring.model.messaging.PremioPregunta;

@Service("premioPreguntaService")
@Transactional
public class PremioPreguntaServiceImpl implements PremioPreguntaService {

    @Autowired
    private PremioPreguntaDao dao;

    public void savePremioPregunta(PremioPregunta premioPregunta) {
        dao.savePremioPregunta(premioPregunta);
    }

    public Set<PremioPregunta> findAllPremioPreguntas() {
        return dao.findAllPremioPreguntas();
    }

    public void deletePremioPreguntaById(long id) {
        dao.deletePremioPreguntaById(id);
    }

    public PremioPregunta findById(long id) {
        return dao.findById(id);
    }

    public void updatePremioPregunta(PremioPregunta premioPregunta) {
        dao.updatePremioPregunta(premioPregunta);
    }
}
