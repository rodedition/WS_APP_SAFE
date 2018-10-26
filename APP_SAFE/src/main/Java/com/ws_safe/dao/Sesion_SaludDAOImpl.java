/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Salud;
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
@Repository("sesion_SaludDAO")
@Transactional
public class Sesion_SaludDAOImpl implements Sesion_SaludDAO{
    Logger logger = Logger.getLogger(Sesion_SaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Sesion_Salud> getListSesion_Salud() {
        return (List<Sesion_Salud>)sessionFactory.getCurrentSession().createCriteria(Sesion_Salud.class).list();
    }
    
    @Override
    public boolean addSesion_Salud(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(sesion_Salud);
        flagsave=true;
        
        return flagsave;
    }

    public Sesion_Salud getByIdSesion_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Sesion_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Sesion_Salud)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSesion_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Sesion_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSesion_Salud(Sesion_Salud sesion_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(sesion_Salud);
        flagsave=true;
        
        return flagsave;
    }   
}
