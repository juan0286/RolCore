/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.configuration;

import com.websystique.spring.dao.AbstractDao;
import org.hibernate.Hibernate;

/**
 *
 * @author TiranoJuan
 */
public class InicializadorDetachedDao extends AbstractDao {
    
    public InicializadorDetachedDao(){};
    
    public void inicializaar(Object o){
        getSession().beginTransaction();
        Hibernate.initialize(o);
    }
    
}
