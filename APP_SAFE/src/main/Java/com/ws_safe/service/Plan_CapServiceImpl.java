/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Plan_CapDAO;
import com.ws_safe.entity.Plan_Cap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("plan_CapService")
public class Plan_CapServiceImpl implements Plan_CapService{
    
    Logger logger = Logger.getLogger(Plan_CapServiceImpl.class);
    
    @Autowired
    @Qualifier("plan_CapDAO")
    
    Plan_CapDAO plan_CapDAOImpl;

   
    public List<Plan_Cap> getListPlan_Cap() {
        return plan_CapDAOImpl.getListPlan_Cap();
    }

   
    public boolean addPlan_Cap(Plan_Cap plan_Cap) {
        return plan_CapDAOImpl.addPlan_Cap(plan_Cap);
    }

    public Plan_Cap getByIdPlan_Cap(Long id) {
        return plan_CapDAOImpl.getByIdPlan_Cap(id);
    }

    public void deletePlan_Cap(Long id) {
        plan_CapDAOImpl.deletePlan_Cap(id);
    }

    public boolean updatePlan_Cap(Plan_Cap plan_Cap) {
        return plan_CapDAOImpl.updatePlan_Cap(plan_Cap);
    }    
    
}