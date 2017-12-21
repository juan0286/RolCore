package com.websystique.spring.dao;

import com.websystique.spring.model.bono.BonoExp;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.objetos.TipoObjeto;
import java.util.HashSet;

@Repository("tipoObjetoDao")
public class TipoObjetoDaoImpl extends AbstractDao implements TipoObjetoDao {

    public void saveTipoObjeto(TipoObjeto objeto) {
        persist(objeto);
    }

    @SuppressWarnings("unchecked")
    public Set<TipoObjeto> findAllTipoObjetos() {
        Criteria criteria = getSession().createCriteria(TipoObjeto.class);
        return new HashSet<TipoObjeto>(criteria.list());

    }

    public void deleteTipoObjetoByNombre(String nombre) {
        Query query = getSession().createSQLQuery("delete from TipoObjeto where nombre = :nombre");
        query.setString("nombre", nombre);
        query.executeUpdate();
    }

    public TipoObjeto findByNombre(String nombre) {
        Criteria criteria = getSession().createCriteria(TipoObjeto.class);
        criteria.add(Restrictions.eq("nombre", nombre));
        return (TipoObjeto) criteria.uniqueResult();
    }

    public void updateTipoObjeto(TipoObjeto objeto) {
        getSession().update(objeto);
    }

    public TipoObjeto findByid(long id) {
         Criteria criteria = getSession().createCriteria(TipoObjeto.class);
        criteria.add(Restrictions.eq("id_tipoObjeto", id));        
        return (TipoObjeto) criteria.uniqueResult();
    }

    
}
