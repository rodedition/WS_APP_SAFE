/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Obs_Ingeniero;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Obs_IngenieroDAO {
    public List<Obs_Ingeniero> getListObs_Ingeniero();
    public boolean addObs_Ingeniero(Obs_Ingeniero obs_Ingeniero);
    public Obs_Ingeniero getByIdObs_Ingeniero (Long id);
    public void deleteObs_Ingeniero (Long id);
    public boolean updateObs_Ingeniero (Obs_Ingeniero obs_Ingeniero);   
}