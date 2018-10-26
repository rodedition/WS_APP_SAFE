/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Trab_Cap;
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
@Repository("list_Trab_CapDAO")
@Transactional
public class List_Trab_CapDAOImpl implements List_Trab_CapDAO{
    Logger logger = Logger.getLogger(List_Trab_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<List_Trab_Cap> getListList_Trab_Cap() {
        return (List<List_Trab_Cap>)sessionFactory.getCurrentSession().createCriteria(List_Trab_Cap.class).list();
    }
    
    @Override
    public boolean addList_Trab_Cap(List_Trab_Cap list_Trab_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(list_Trab_Cap);
        flagsave=true;
        
        return flagsave;
    }

    public List_Trab_Cap getByIdList_Trab_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM List_Trab_Cap as c WHERE c.idlistrabcap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (List_Trab_Cap)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteList_Trab_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM List_Trab_Cap as c WHERE c.idlistrabcap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateList_Trab_Cap(List_Trab_Cap list_Trab_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(list_Trab_Cap);
        flagsave=true;
        
        return flagsave;
    }   
}
