/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Supervisor;
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
@Repository("obs_SupervisorDAO")
@Transactional
public class Obs_SupervisorDAOImpl implements Obs_SupervisorDAO{
    Logger logger = Logger.getLogger(Obs_SupervisorDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Obs_Supervisor> getListObs_Supervisor() {
        return (List<Obs_Supervisor>)sessionFactory.getCurrentSession().createCriteria(Obs_Supervisor.class).list();
    }
    
    @Override
    public boolean addObs_Supervisor(Obs_Supervisor obs_Supervisor) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(obs_Supervisor);
        flagsave=true;
        
        return flagsave;
    }

    public Obs_Supervisor getByIdObs_Supervisor(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Obs_Supervisor as c WHERE c.idobssupervisor=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Obs_Supervisor)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteObs_Supervisor(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Obs_Supervisor as c WHERE c.idobssupervisor=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateObs_Supervisor(Obs_Supervisor obs_Supervisor) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(obs_Supervisor);
        flagsave=true;
        
        return flagsave;
    }   
}
