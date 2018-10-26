/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Cap;
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
@Repository("sesion_CapDAO")
@Transactional
public class Sesion_CapDAOImpl implements Sesion_CapDAO{
    Logger logger = Logger.getLogger(Sesion_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Sesion_Cap> getListSesion_Cap() {
        return (List<Sesion_Cap>)sessionFactory.getCurrentSession().createCriteria(Sesion_Cap.class).list();
    }
    
    @Override
    public boolean addSesion_Cap(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(sesion_Cap);
        flagsave=true;
        
        return flagsave;
    }

    public Sesion_Cap getByIdSesion_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Sesion_Cap as c WHERE c.idsesioncap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Sesion_Cap)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSesion_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Sesion_Cap as c WHERE c.idsesioncap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSesion_Cap(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(sesion_Cap);
        flagsave=true;
        
        return flagsave;
    }   
}
