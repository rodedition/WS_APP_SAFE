/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Plan_Cap;
import com.ws_safe.service.Plan_CapService;
import com.ws_safe.service.Plan_CapServiceImpl;
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
@RequestMapping("/planCapacitacion")
public class Plan_CapRest {
    Logger logger = Logger.getLogger(Plan_CapRest.class);
    @Autowired
    @Qualifier("plan_CapService")
    Plan_CapService plan_CapServiceImpl;
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getPlan_CapJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonPlanC="";
        List<Plan_Cap> listPlan_Cap = new ArrayList<Plan_Cap>();        
        try {
            listPlan_Cap = plan_CapServiceImpl.getListPlan_Cap();
            logger.info("La cantidad de planes son: "+listPlan_Cap.size());
            jsonPlanC = gson.toJson(listPlan_Cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanC;
    }
    
    @RequestMapping(value="/createPlanCapacitacion",method=RequestMethod.POST,produces="application/json")
    public String savePlanC(@RequestBody Plan_Cap plan_Cap){
        String jsonPlanC = "";
        boolean getresponse = false;
        try {
            getresponse = plan_CapServiceImpl.addPlan_Cap(plan_Cap);
            jsonPlanC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanC;
    }
    
    @RequestMapping(value="/deletePlanCapacitacion/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deletePlan_Cap(@PathVariable("id") String id){
        plan_CapServiceImpl.deletePlan_Cap(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOnePlanCapacitacion/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Plan_Cap getOnePlan_Cap (@PathVariable("id") String id){
        return plan_CapServiceImpl.getByIdPlan_Cap(new Long (id));
    }
    
    @RequestMapping(value="/updatePlanCapacitacion",method=RequestMethod.PUT,produces="application/json")
    public String updatePlan_Cap(@RequestBody Plan_Cap plan_Cap){
        String jsonPlanC = "";
        boolean getresponse = false;
        try {
            getresponse = plan_CapServiceImpl.updatePlan_Cap(plan_Cap);
            jsonPlanC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlanC;
    }

}
