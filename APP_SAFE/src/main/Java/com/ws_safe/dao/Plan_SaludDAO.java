/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Plan_Salud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Plan_SaludDAO {
    public List<Plan_Salud> getListPlan_Salud();
    public boolean addPlan_Salud(Plan_Salud plan_Salud);
    public Plan_Salud getByIdPlan_Salud (Long id);
    public void deletePlan_Salud (Long id);
    public boolean updatePlan_Salud (Plan_Salud plan_Salud);   
}
