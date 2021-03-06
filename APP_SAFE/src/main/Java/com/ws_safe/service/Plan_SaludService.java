/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Plan_Salud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Plan_SaludService {
    
    
    //Interfaces para llamadas a PROCEDURE
    public List<Plan_Salud> addPlanSaludSP(Plan_Salud plan_Salud);
    public List<Plan_Salud> getByIdPlanSaludSP(Long id);
    public List<Plan_Salud> getAllPlanSaludSP();
    public boolean updatePlanSaludSP (Plan_Salud plan_Salud);
    public void deletePlanSaludSP(Long id, Long estado);
}

