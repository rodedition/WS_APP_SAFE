/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Plan_Salud;
import com.ws_safe.service.Plan_SaludService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo
 */
@RestController
@RequestMapping("/planSalud")
public class Plan_SaludRest {
    Logger logger = Logger.getLogger(Plan_SaludRest.class);
    @Autowired
    @Qualifier("plan_SaludService")
    Plan_SaludService plan_SaludServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createPlanSaludSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Plan_Salud> savePlanSaludSP(@RequestBody Plan_Salud plan_Salud){
        return plan_SaludServiceImpl.addPlanSaludSP(plan_Salud);
    }
    
    @RequestMapping(value="/readOnePlanSalud/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Plan_Salud> readOnePlanSalud (@PathVariable("id") String id){
        return plan_SaludServiceImpl.getByIdPlanSaludSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllPlanSalud/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Plan_Salud> getAllPlanSaludSP (){
        return plan_SaludServiceImpl.getAllPlanSaludSP();
    }
    
    @RequestMapping(value="/upPlanSalud",method=RequestMethod.PUT,produces="application/json")
    public String updatePlanSaludSP(@RequestBody Plan_Salud plan_Salud){
        String jsonPlan = "";
        boolean getresponse = false;
        try {
            getresponse = plan_SaludServiceImpl.updatePlanSaludSP(plan_Salud);
            jsonPlan = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlan;
    }

    @RequestMapping(value="/deletePlanSalud/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deletePlanSaludSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        plan_SaludServiceImpl.deletePlanSaludSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
