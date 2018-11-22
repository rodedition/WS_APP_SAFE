/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Plan_Cap;
import com.ws_safe.service.Plan_CapService;
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
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createPlanCapSP",method=RequestMethod.POST,produces="application/json")
    public String savePlanCapSP(@RequestBody Plan_Cap plan_Cap){
        String jsonPlan = "";
        boolean getresponse = false;
        try {
            getresponse = plan_CapServiceImpl.addPlanCapSP(plan_Cap);
            jsonPlan = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlan;
    }
    
    @RequestMapping(value="/readOnePlanCap/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Plan_Cap> readOnePlanCap (@PathVariable("id") String id){
        return plan_CapServiceImpl.getByIdPlanCapSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllPlanCap/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Plan_Cap> getAllPlanCapSP (){
        return plan_CapServiceImpl.getAllPlanCapSP();
    }
    
    @RequestMapping(value="/upPlanCap",method=RequestMethod.PUT,produces="application/json")
    public String updatePlanCapSP(@RequestBody Plan_Cap plan_Cap){
        String jsonPlan = "";
        boolean getresponse = false;
        try {
            getresponse = plan_CapServiceImpl.updatePlanCapSP(plan_Cap);
            jsonPlan = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPlan;
    }

    @RequestMapping(value="/deletePlanCap/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deletePlanCapSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        plan_CapServiceImpl.deletePlanCapSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
