/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Obs_Ingeniero;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Obs_IngenieroService {
    //Interfaces para llamadas directas a base de datos
    public List<Obs_Ingeniero> getListObs_Ingeniero();
    public boolean addObs_Ingeniero(Obs_Ingeniero obs_Ingeniero);
    public Obs_Ingeniero getByIdObs_Ingeniero (Long id);
    public void deleteObs_Ingeniero (Long id);
    public boolean updateObs_Ingeniero (Obs_Ingeniero obs_Ingeniero);
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addObsIngSP(Obs_Ingeniero obs_Ingeniero);
    public List<Obs_Ingeniero> getByIdObsIngSP(Long id);
    public List<Obs_Ingeniero> getAllObsIngSP();
    public boolean updateObsIngSP (Obs_Ingeniero obs_Ingeniero);
    public void deleteObsIngSP(Long id, Long estado);
}

