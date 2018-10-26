/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Eval_Terr;
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
@Repository("eval_TerrDAO")
@Transactional
public class Eval_TerrDAOImpl implements Eval_TerrDAO{
    Logger logger = Logger.getLogger(Eval_TerrDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Eval_Terr> getListEval_Terr() {
        return (List<Eval_Terr>)sessionFactory.getCurrentSession().createCriteria(Eval_Terr.class).list();
    }
    
    @Override
    public boolean addEval_Terr(Eval_Terr eval_terr) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(eval_terr);
        flagsave=true;
        
        return flagsave;
    }

    public Eval_Terr getByIdEval_Terr(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Eval_Terr as c WHERE c.idevalterr=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Eval_Terr)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteEval_Terr(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Eval_Terr as c WHERE c.idevalterr=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateEval_Terr(Eval_Terr eval_Terr) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(eval_Terr);
        flagsave=true;
        
        return flagsave;
    }   

}
