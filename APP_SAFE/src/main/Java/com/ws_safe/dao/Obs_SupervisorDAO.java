/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Supervisor;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Obs_SupervisorDAO {
    public List<Obs_Supervisor> getListObs_Supervisor();
    public boolean addObs_Supervisor(Obs_Supervisor obs_Supervisor);
    public Obs_Supervisor getByIdObs_Supervisor (Long id);
    public void deleteObs_Supervisor (Long id);
    public boolean updateObs_Supervisor (Obs_Supervisor obs_Supervisor);   
}
