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

    //Servicios para llamadas a PROCEDURE

    @Override
    public boolean addObsIngSP(Obs_Ingeniero obs_Ingeniero) {
        return obs_IngenieroDAOImpl.addObsIngSP(obs_Ingeniero);
    }

    @Override
    public List<Obs_Ingeniero> getByIdObsIngSP(Long id) {
        return obs_IngenieroDAOImpl.getByIdObsIngSP(id);
    }

    @Override
    public List<Obs_Ingeniero> getAllObsIngSP() {
        return obs_IngenieroDAOImpl.getAllObsIngSP();
    }

    @Override
    public boolean updateObsIngSP(Obs_Ingeniero obs_Ingeniero) {
        return obs_IngenieroDAOImpl.updateObsIngSP(obs_Ingeniero);
    }

    @Override
    public void deleteObsIngSP(Long id, Long estado) {
        obs_IngenieroDAOImpl.deleteObsIngSP(id, estado);
    }
    
    
}
