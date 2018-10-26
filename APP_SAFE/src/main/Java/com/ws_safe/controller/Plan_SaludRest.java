/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Plan_Salud;
import com.ws_safe.service.Plan_SaludService;
import com.ws_safe.service.Plan_SaludServiceImpl;
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
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getPlan_SaludJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonPlanS="";
        List<Plan_Salud> listPlan_Salud = new ArrayList<Plan_Salud>();        
        try {
            listPlan_Salud = plan_SaludServiceImpl.getListPlan_Salud();
            logger.info("La cantidad de planes son: "+listPlan_Salud.size());
            jsonPlanS = gson.toJson(listPlan_Salud);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanS;
    }
    
    @RequestMapping(value="/createPlanSalud",method=RequestMethod.POST,produces="application/json")
    public String savePlanS(@RequestBody Plan_Salud plan_Salud){
        String jsonPlanS = "";
        boolean getresponse = false;
        try {
            getresponse = plan_SaludServiceImpl.addPlan_Salud(plan_Salud);
            jsonPlanS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanS;
    }
    
    @RequestMapping(value="/deletePlanSalud/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deletePlan_Salud(@PathVariable("id") String id){
        plan_SaludServiceImpl.deletePlan_Salud(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOnePlanSalud/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Plan_Salud getOnePlan_Salud (@PathVariable("id") String id){
        return plan_SaludServiceImpl.getByIdPlan_Salud(new Long (id));
    }
    
    @RequestMapping(value="/updatePlanSalud",method=RequestMethod.PUT,produces="application/json")
    public String updatePlan_Salud(@RequestBody Plan_Salud plan_Salud){
        String jsonPlanS = "";
        boolean getresponse = false;
        try {
            getresponse = plan_SaludServiceImpl.updatePlan_Salud(plan_Salud);
            jsonPlanS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanS;
    }

}
