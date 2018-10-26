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
    public List<Plan_Cap> getListPlan_Cap();
    public boolean addPlan_Cap(Plan_Cap plan_Cap);
    public Plan_Cap getByIdPlan_Cap (Long id);
    public void deletePlan_Cap (Long id);
    public boolean updatePlan_Cap (Plan_Cap plan_Cap);   
}
