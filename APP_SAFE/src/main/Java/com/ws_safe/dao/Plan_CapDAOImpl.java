/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Cap;
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
@Repository("plan_CapDAO")
@Transactional
public class Plan_CapDAOImpl implements Plan_CapDAO{
    Logger logger = Logger.getLogger(Plan_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Plan_Cap> getListPlan_Cap() {
        return (List<Plan_Cap>)sessionFactory.getCurrentSession().createCriteria(Plan_Cap.class).list();
    }
    
    @Override
    public boolean addPlan_Cap(Plan_Cap plan_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(plan_Cap);
        flagsave=true;
        
        return flagsave;
    }

    public Plan_Cap getByIdPlan_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Plan_Cap as c WHERE c.idplancap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Plan_Cap)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deletePlan_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Plan_Cap as c WHERE c.idplancap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updatePlan_Cap(Plan_Cap plan_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(plan_Cap);
        flagsave=true;
        
        return flagsave;
    }   
}
