/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Medico;
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
@Repository("medicoDAO")
@Transactional
public class MedicoDAOImpl implements MedicoDAO{
    Logger logger = Logger.getLogger(MedicoDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    public List<Medico> getListMedico() {
        return (List<Medico>)sessionFactory.getCurrentSession().createCriteria(Medico.class).list();
    }
    
    @Override
    public boolean addMedico(Medico medico) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(medico);
        flagsave=true;
        
        return flagsave;
    }

    public Medico getByIdMedico(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Medico as c WHERE c.idmedico=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Medico)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteMedico(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Medico as c WHERE c.idmedico=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateMedico(Medico medico) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(medico);
        flagsave=true;
        
        return flagsave;
    }   
}
