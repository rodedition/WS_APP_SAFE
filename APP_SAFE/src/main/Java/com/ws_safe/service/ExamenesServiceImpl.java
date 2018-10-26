/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.ExamenesDAO;
import com.ws_safe.entity.Examenes;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("examenesService")
public class ExamenesServiceImpl implements ExamenesService{
    
    Logger logger = Logger.getLogger(ExamenesServiceImpl.class);
    
    @Autowired
    @Qualifier("examenesDAO")
    
    ExamenesDAO examenesDAOImpl;

   
    public List<Examenes> getListExamen() {
        return examenesDAOImpl.getListExamen();
    }

   
    public boolean addExamen(Examenes examenes) {
        return examenesDAOImpl.addExamen(examenes);
    }

    public Examenes getByIdExamen(Long id) {
        return examenesDAOImpl.getByIdExamen(id);
    }

    public void deleteExamen(Long id) {
        examenesDAOImpl.deleteExamen(id);
    }

    public boolean updateExamen(Examenes examenes) {
        return examenesDAOImpl.updateExamen(examenes);
    }    
    
}
