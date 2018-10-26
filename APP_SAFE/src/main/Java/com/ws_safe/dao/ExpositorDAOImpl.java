/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Expositor;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodrigo
 */
@Repository("expositorDAO")
@Transactional
public class ExpositorDAOImpl implements ExpositorDAO{
    Logger logger = Logger.getLogger(ExpositorDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Expositor> getListExpositor() {
        return (List<Expositor>)sessionFactory.getCurrentSession().createCriteria(Expositor.class).list();
    }
    
    @Override
    public boolean addExpositor(Expositor expositor) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(expositor);
        flagsave=true;
        
        return flagsave;
    }

    public Expositor getByIdExpositor(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Expositor as c WHERE c.idexpositor=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Expositor)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteExpositor(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Expositor as c WHERE c.idexpositor=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateExpositor(Expositor expositor) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(expositor);
        flagsave=true;
        
        return flagsave;
    }   
}
