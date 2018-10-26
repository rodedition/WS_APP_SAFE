/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Obs_IngenieroDAO;
import com.ws_safe.entity.Obs_Ingeniero;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("obs_IngenieroService")
public class Obs_IngenieroServiceImpl implements Obs_IngenieroService{
    
    Logger logger = Logger.getLogger(Obs_IngenieroServiceImpl.class);
    
    @Autowired
    @Qualifier("obs_IngenieroDAO")
    
    Obs_IngenieroDAO obs_IngenieroDAOImpl;

   
    public List<Obs_Ingeniero> getListObs_Ingeniero() {
        return obs_IngenieroDAOImpl.getListObs_Ingeniero();
    }

   
    public boolean addObs_Ingeniero(Obs_Ingeniero obs_Ingeniero) {
        return obs_IngenieroDAOImpl.addObs_Ingeniero(obs_Ingeniero);
    }

    public Obs_Ingeniero getByIdObs_Ingeniero(Long id) {
        return obs_IngenieroDAOImpl.getByIdObs_Ingeniero(id);
    }

    public void deleteObs_Ingeniero(Long id) {
        obs_IngenieroDAOImpl.deleteObs_Ingeniero(id);
    }

    public boolean updateObs_Ingeniero(Obs_Ingeniero obs_Ingeniero) {
        return obs_IngenieroDAOImpl.updateObs_Ingeniero(obs_Ingeniero);
    }    
    
}
