/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Capacitacion;
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
@Repository("capacitacionDAO")
@Transactional
public class CapacitacionDAOImpl implements CapacitacionDAO{
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //private EntityManager em;
    
    @Override
    public List<Capacitacion> getListCapacitacion() {
        return (List<Capacitacion>)sessionFactory.getCurrentSession().createCriteria(Capacitacion.class).list();
    }
    
    @Override
    public boolean addCap(Capacitacion capacitacion) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(capacitacion);
        flagsave=true;
        
        return flagsave;
    }

    public Capacitacion getByIdCap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Capacitacion as c WHERE c.idcap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Capacitacion)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Capacitacion as c WHERE c.idcap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCap(Capacitacion capacitacion) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(capacitacion);
        flagsave=true;
        
        return flagsave;
    }   
}
