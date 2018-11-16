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
    
    //Interfaces para llamadas directas a base de datos
    public List<Plan_Salud> getListPlan_Salud();
    public boolean addPlan_Salud(Plan_Salud plan_Salud);
    public Plan_Salud getByIdPlan_Salud (Long id);
    public void deletePlan_Salud (Long id);
    public boolean updatePlan_Salud (Plan_Salud plan_Salud);
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addPlanSaludSP(Plan_Salud plan_Salud);
    public List<Plan_Salud> getByIdPlanSaludSP(Long id);
    public List<Plan_Salud> getAllPlanSaludSP();
    public boolean updatePlanSaludSP (Plan_Salud plan_Salud);
    public void deletePlanSaludSP(Long id, Long estado);
}

