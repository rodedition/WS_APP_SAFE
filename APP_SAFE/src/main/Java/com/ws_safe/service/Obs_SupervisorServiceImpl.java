/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Obs_SupervisorDAO;
import com.ws_safe.entity.Obs_Supervisor;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("obs_SupervisorService")
public class Obs_SupervisorServiceImpl implements Obs_SupervisorService{
    
    Logger logger = Logger.getLogger(Obs_SupervisorServiceImpl.class);
    
    @Autowired
    @Qualifier("obs_SupervisorDAO")
    
    Obs_SupervisorDAO obs_SupervisorDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Obs_Supervisor> addObsSupSP(Obs_Supervisor obs_Supervisor) {
        return obs_SupervisorDAOImpl.addObsSupSP(obs_Supervisor);
    }

    @Override
    public List<Obs_Supervisor> getByIdObsSupSP(Long id) {
        return obs_SupervisorDAOImpl.getByIdObsSupSP(id);
    }

    @Override
    public List<Obs_Supervisor> getAllObsSupSP() {
        return obs_SupervisorDAOImpl.getAllObsSupSP();
    }

    @Override
    public boolean updateObsSupSP(Obs_Supervisor obs_Supervisor) {
        return obs_SupervisorDAOImpl.updateObsSupSP(obs_Supervisor);
    }

    @Override
    public void deleteObsSupSP(Long id, Long estado) {
        obs_SupervisorDAOImpl.deleteObsSupSP(id, estado);
    }
    
    
    
}
