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



public interface IService {

    void save(Object o);

    Set<Object> findAllFromMundo(long id);

    void deleteById(long id);

    Object findById(long id);

    void update(Object o);
    
    
}
