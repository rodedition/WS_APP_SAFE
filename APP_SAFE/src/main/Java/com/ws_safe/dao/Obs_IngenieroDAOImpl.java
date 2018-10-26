/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Ingeniero;
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
@Repository("obs_IngenieroDAO")
@Transactional
public class Obs_IngenieroDAOImpl implements Obs_IngenieroDAO{
    Logger logger = Logger.getLogger(Obs_IngenieroDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Obs_Ingeniero> getListObs_Ingeniero() {
        return (List<Obs_Ingeniero>)sessionFactory.getCurrentSession().createCriteria(Obs_Ingeniero.class).list();
    }
    
    @Override
    public boolean addObs_Ingeniero(Obs_Ingeniero obs_Ingeniero) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(obs_Ingeniero);
        flagsave=true;
        
        return flagsave;
    }

    public Obs_Ingeniero getByIdObs_Ingeniero(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Obs_Ingeniero as c WHERE c.idobsingeniero=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Obs_Ingeniero)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteObs_Ingeniero(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Obs_Ingeniero as c WHERE c.idobsingeniero=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateObs_Ingeniero(Obs_Ingeniero obs_Ingeniero) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(obs_Ingeniero);
        flagsave=true;
        
        return flagsave;
    }   
}
