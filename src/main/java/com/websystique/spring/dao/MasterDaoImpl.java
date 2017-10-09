package com.websystique.spring.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Master;
import com.websystique.spring.model.caractPj.Hab_secundaria;
import java.util.HashSet;

@Repository("masterDao")
public class MasterDaoImpl extends AbstractDao implements MasterDao {

    public void saveMaster(Master master) {
        persist(master);
    }

    @SuppressWarnings("unchecked")
    public Set<Master> findAllMasters() {
        Criteria criteria = getSession().createCriteria(Master.class);
        return  new HashSet<Master>(criteria.list());
    }

    public void deleteMasterById(long id) {
        //Query query = getSession().createSQLQuery("delete from com.websystique.spring.model.Master where id_master = :id");
        Master m = findById(id);
//        query.setLong("id_master", id);
        //query.setParameter("id", id);
        getSession().delete(m);
    }

    public Master findById(long id) {
        Criteria criteria = getSession().createCriteria(Master.class);
        criteria.add(Restrictions.eq("id_master", id));
        return (Master) criteria.uniqueResult();
    }

    public void updateMaster(Master master) {
        getSession().update(master);
    }

    public Master findByUser(String user) {
        Criteria criteria = getSession().createCriteria(Master.class);
        criteria.add(Restrictions.eq("usuario", user));
        return (Master) criteria.uniqueResult();
    }

    public Master findByName(String name) {
        Criteria criteria = getSession().createCriteria(Master.class);
        criteria.add(Restrictions.eq("nombre", name));
        return (Master) criteria.uniqueResult();
    }

}
