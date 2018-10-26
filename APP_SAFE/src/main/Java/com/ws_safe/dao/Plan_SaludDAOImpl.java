/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Salud;
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
@Repository("plan_SaludDAO")
@Transactional
public class Plan_SaludDAOImpl implements Plan_SaludDAO{
    Logger logger = Logger.getLogger(Plan_SaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Plan_Salud> getListPlan_Salud() {
        return (List<Plan_Salud>)sessionFactory.getCurrentSession().createCriteria(Plan_Salud.class).list();
    }
    
    @Override
    public boolean addPlan_Salud(Plan_Salud plan_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(plan_Salud);
        flagsave=true;
        
        return flagsave;
    }

    public Plan_Salud getByIdPlan_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Plan_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Plan_Salud)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deletePlan_Salud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Plan_Salud as c WHERE c.idsesionsalud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updatePlan_Salud(Plan_Salud plan_Salud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(plan_Salud);
        flagsave=true;
        
        return flagsave;
    }   
}
