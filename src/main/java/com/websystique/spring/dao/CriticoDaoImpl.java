/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.spring.dao;

import com.websystique.spring.model.combate.CodeCritico;
import com.websystique.spring.model.combate.Critico;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TiranoJuan
 */
@Repository("criticoDao")
public class CriticoDaoImpl extends AbstractDao implements CriticoDao {

    public void saveCritico(Critico critico) {
        persist(critico);
    }

    @SuppressWarnings("unchecked")
    public Set<Critico> findAllCriticos() {
        Criteria criteria = getSession().createCriteria(Critico.class);
        return new HashSet<Critico>(criteria.list());
    }

    public void deleteCriticoById(CodeCritico id) {
        Critico c = findById(id);
        getSession().delete(c);
    }

    public Critico findById(CodeCritico id) {
//        String querystring = "from Critico c where c.id_critico = ('" + id.getLetraCrit() + "','" + id.getPosition() + "','" + id.getTabla() + "')";
//        Query query = getSession().createSQLQuery(querystring);
//        
        Criteria criteria = getSession().createCriteria(Critico.class);
        criteria.                
                add(Restrictions.eq("id_critico.position", id.getPosition())).
                add(Restrictions.eq("id_critico.letraCrit", id.getLetraCrit())).
                add(Restrictions.eq("id_critico.tabla", id.getTabla()));

        Critico ret = (Critico) criteria.uniqueResult();
        return ret;
    }

    public void updateCritico(Critico critico) {
        getSession().update(critico);
    }

}
