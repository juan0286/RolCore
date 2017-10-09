package com.websystique.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.spring.dao.MasterDao;
import com.websystique.spring.model.Master;

@Service("masterService")
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao dao;

    public void saveMaster(Master master) {
        dao.saveMaster(master);
    }

    public Set<Master> findAllMasters() {
        return dao.findAllMasters();
    }

    public void deleteMasterById(long id) {
        dao.deleteMasterById(id);
    }

    public Master findById(long id) {
        return dao.findById(id);
    }

    public void updateMaster(Master master) {
        dao.updateMaster(master);
    }

    public Master findByName(String name) {
        return dao.findByName(name);
    }

    public Master findByUser(String user) {
        return dao.findByUser(user);
    }
}
