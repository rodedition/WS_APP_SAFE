/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Plan_SaludDAO;
import com.ws_safe.entity.Plan_Salud;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("plan_SaludService")
public class Plan_SaludServiceImpl implements Plan_SaludService{
    
    Logger logger = Logger.getLogger(Plan_SaludServiceImpl.class);
    
    @Autowired
    @Qualifier("plan_SaludDAO")
    
    Plan_SaludDAO plan_SaludDAOImpl;

    //Servicios para llamadas a base de datos directa
   
    public List<Plan_Salud> getListPlan_Salud() {
        return plan_SaludDAOImpl.getListPlan_Salud();
    }

   
    public boolean addPlan_Salud(Plan_Salud plan_Salud) {
        return plan_SaludDAOImpl.addPlan_Salud(plan_Salud);
    }

    public Plan_Salud getByIdPlan_Salud(Long id) {
        return plan_SaludDAOImpl.getByIdPlan_Salud(id);
    }

    public void deletePlan_Salud(Long id) {
        plan_SaludDAOImpl.deletePlan_Salud(id);
    }

    public boolean updatePlan_Salud(Plan_Salud plan_Salud) {
        return plan_SaludDAOImpl.updatePlan_Salud(plan_Salud);
    }    
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public boolean addPlanSaludSP(Plan_Salud plan_Salud) {
        return plan_SaludDAOImpl.addPlanSaludSP(plan_Salud);
    }

    @Override
    public List<Plan_Salud> getByIdPlanSaludSP(Long id) {
        return plan_SaludDAOImpl.getByIdPlanSaludSP(id);
    }

    @Override
    public List<Plan_Salud> getAllPlanSaludSP() {
        return plan_SaludDAOImpl.getAllPlanSaludSP();
    }

    @Override
    public boolean updatePlanSaludSP(Plan_Salud plan_Salud) {
        return plan_SaludDAOImpl.updatePlanSaludSP(plan_Salud);
    }

    @Override
    public void deletePlanSaludSP(Long id, Long estado) {
        plan_SaludDAOImpl.deletePlanSaludSP(id, estado);
    }
    
    
    
}
