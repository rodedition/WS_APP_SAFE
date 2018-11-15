/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.ExpositorDAO;
import com.ws_safe.entity.Expositor;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("expositorService")
public class ExpositorServiceImpl implements ExpositorService{
    
    Logger logger = Logger.getLogger(ExpositorServiceImpl.class);
    
    @Autowired
    @Qualifier("expositorDAO")
    
    ExpositorDAO expositorDAOImpl;
    
    //Servicios para llamadas a base de datos directa

   
    public List<Expositor> getListExpositor() {
        return expositorDAOImpl.getListExpositor();
    }

   
    public boolean addExpositor(Expositor expositor) {
        return expositorDAOImpl.addExpositor(expositor);
    }

    public Expositor getByIdExpositor(Long id) {
        return expositorDAOImpl.getByIdExpositor(id);
    }

    public void deleteExpositor(Long id) {
        expositorDAOImpl.deleteExpositor(id);
    }

    public boolean updateExpositor(Expositor expositor) {
        return expositorDAOImpl.updateExpositor(expositor);
    }    
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public boolean addExpositorSP(Expositor expositor) {
        return expositorDAOImpl.addExpositorSP(expositor);
    }

    @Override
    public List<Expositor> getByIdExpositorSP(Long id) {
        return expositorDAOImpl.getByIdExpositorSP(id);
    }

    @Override
    public List<Expositor> getAllExpositoresSP() {
        return expositorDAOImpl.getAllExpositoresSP();
    }

    @Override
    public boolean updateExpositorSP(Expositor expositor) {
        return expositorDAOImpl.updateExpositorSP(expositor);
    }

    @Override
    public void deleteExpositorSP(Long id, Long estado) {
        expositorDAOImpl.deleteExpositorSP(id, estado);
    }
    
}
