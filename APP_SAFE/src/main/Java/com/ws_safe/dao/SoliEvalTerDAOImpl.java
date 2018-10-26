/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.SoliEvalTer;
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
@Repository("soliEvalTerDAO")
@Transactional
public class SoliEvalTerDAOImpl implements SoliEvalTerDAO{
    Logger logger = Logger.getLogger(SoliEvalTerDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<SoliEvalTer> getListSoliEvalTer() {
        return (List<SoliEvalTer>)sessionFactory.getCurrentSession().createCriteria(SoliEvalTer.class).list();
    }
    
    @Override
    public boolean addSoliEvalTer(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(soliEvalTer);
        flagsave=true;
        
        return flagsave;
    }

    public SoliEvalTer getByIdSoliEvalTer(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM SoliEvalTer as c WHERE c.idsolicitud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (SoliEvalTer)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSoliEvalTer(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM SoliEvalTer as c WHERE c.idsolicitud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSoliEvalTer(SoliEvalTer soliEvalTer) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(soliEvalTer);
        flagsave=true;
        
        return flagsave;
    }   
}
