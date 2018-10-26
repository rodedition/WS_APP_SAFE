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
    
}
