package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.JugadorDao;
import com.websystique.spring.model.Jugador;

@Service("jugadorService")
@Transactional
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorDao dao;

    public void saveJugador(Jugador jugador) {
        dao.saveJugador(jugador);
    }

    public Set<Jugador> findAllJugadors() {
        return dao.findAllJugadors();
    }

    public void deleteJugadorById(long id) {
        dao.deleteJugadorById(id);
    }

    public Jugador findById(long id) {
        return dao.findById(id);
    }

    public void updateJugador(Jugador jugador) {
        dao.updateJugador(jugador);
    }

    public Jugador findByName(String name) {
        return dao.findByName(name);
    }

    public Jugador findByUser(String user) {
        return dao.findByName(user);
    }
}
