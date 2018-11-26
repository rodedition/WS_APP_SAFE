/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Obs_Supervisor;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Obs_SupervisorService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Obs_Supervisor> addObsSupSP(Obs_Supervisor obs_Supervisor);
    public List<Obs_Supervisor> getByIdObsSupSP(Long id);
    public List<Obs_Supervisor> getAllObsSupSP();
    public boolean updateObsSupSP (Obs_Supervisor obs_Supervisor);
    public void deleteObsSupSP(Long id, Long estado);
}

