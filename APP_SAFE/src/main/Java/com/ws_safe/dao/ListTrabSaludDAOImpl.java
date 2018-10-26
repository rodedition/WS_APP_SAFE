/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.ListTrabSalud;
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
@Repository("listTrabSaludDAO")
@Transactional
public class ListTrabSaludDAOImpl implements ListTrabSaludDAO{
    Logger logger = Logger.getLogger(ListTrabSaludDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<ListTrabSalud> getListListTrabSalud() {
        return (List<ListTrabSalud>)sessionFactory.getCurrentSession().createCriteria(ListTrabSalud.class).list();
    }
    
    @Override
    public boolean addListTrabSalud(ListTrabSalud listTrabSalud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(listTrabSalud);
        flagsave=true;
        
        return flagsave;
    }

    public ListTrabSalud getByIdListTrabSalud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM ListTrabSalud as c WHERE c.idlistrabsalud=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (ListTrabSalud)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteListTrabSalud(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM ListTrabSalud as c WHERE c.idlistrabsalud=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateListTrabSalud(ListTrabSalud listTrabSalud) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(listTrabSalud);
        flagsave=true;
        
        return flagsave;
    }   
}
