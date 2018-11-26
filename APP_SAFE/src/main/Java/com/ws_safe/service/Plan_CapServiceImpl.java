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

    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Plan_Cap> addPlanCapSP(Plan_Cap plan_Cap) {
        return plan_CapDAOImpl.addPlanCapSP(plan_Cap);
    }

    @Override
    public List<Plan_Cap> getByIdPlanCapSP(Long id) {
        return plan_CapDAOImpl.getByIdPlanCapSP(id);
    }

    @Override
    public List<Plan_Cap> getAllPlanCapSP() {
        return plan_CapDAOImpl.getAllPlanCapSP();
    }

    @Override
    public boolean updatePlanCapSP(Plan_Cap plan_Cap) {
        return plan_CapDAOImpl.updatePlanCapSP(plan_Cap);
    }

    @Override
    public void deletePlanCapSP(Long id, Long estado) {
        plan_CapDAOImpl.deletePlanCapSP(id, estado);
    }
}
