/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Plan_CapDAO {
       
    //Interfaces para llamadas a PROCEDURE
    public boolean addPlanCapSP(Plan_Cap plan_Cap);
    public List<Plan_Cap> getByIdPlanCapSP(Long id);
    public List<Plan_Cap> getAllPlanCapSP();
    public boolean updatePlanCapSP (Plan_Cap plan_Cap);
    public void deletePlanCapSP(Long id, Long estado);
}
