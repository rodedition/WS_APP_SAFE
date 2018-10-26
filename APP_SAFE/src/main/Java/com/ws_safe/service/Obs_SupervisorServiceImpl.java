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

   
    public List<Obs_Supervisor> getListObs_Supervisor() {
        return obs_SupervisorDAOImpl.getListObs_Supervisor();
    }

   
    public boolean addObs_Supervisor(Obs_Supervisor obs_Supervisor) {
        return obs_SupervisorDAOImpl.addObs_Supervisor(obs_Supervisor);
    }

    public Obs_Supervisor getByIdObs_Supervisor(Long id) {
        return obs_SupervisorDAOImpl.getByIdObs_Supervisor(id);
    }

    public void deleteObs_Supervisor(Long id) {
        obs_SupervisorDAOImpl.deleteObs_Supervisor(id);
    }

    public boolean updateObs_Supervisor(Obs_Supervisor obs_Supervisor) {
        return obs_SupervisorDAOImpl.updateObs_Supervisor(obs_Supervisor);
    }    
    
}
