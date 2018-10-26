/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Examenes;
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
@Repository("examenesDAO")
@Transactional
public class ExamenesDAOImpl implements ExamenesDAO{
    Logger logger = Logger.getLogger(ExamenesDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Examenes> getListExamen() {
        return (List<Examenes>)sessionFactory.getCurrentSession().createCriteria(Examenes.class).list();
    }
    
    @Override
    public boolean addExamen(Examenes examenes) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(examenes);
        flagsave=true;
        
        return flagsave;
    }

    public Examenes getByIdExamen(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Examenes as c WHERE c.idexamen=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Examenes)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteExamen(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Examenes as c WHERE c.idexamen=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateExamen(Examenes examenes) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(examenes);
        flagsave=true;
        
        return flagsave;
    }   
}
