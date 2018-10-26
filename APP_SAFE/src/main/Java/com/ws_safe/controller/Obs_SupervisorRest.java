/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Obs_Supervisor;
import com.ws_safe.service.Obs_SupervisorService;
import com.ws_safe.service.Obs_SupervisorServiceImpl;
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
@RequestMapping("/obsSupervisor")
public class Obs_SupervisorRest {
    Logger logger = Logger.getLogger(Obs_SupervisorRest.class);
    @Autowired
    @Qualifier("obs_SupervisorService")
    Obs_SupervisorService obs_SupervisorServiceImpl;
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getObs_SupervisorJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonObsS="";
        List<Obs_Supervisor> listObs_Supervisor = new ArrayList<Obs_Supervisor>();        
        try {
            listObs_Supervisor = obs_SupervisorServiceImpl.getListObs_Supervisor();
            logger.info("La cantidad de observaciones son: "+listObs_Supervisor.size());
            jsonObsS = gson.toJson(listObs_Supervisor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObsS;
    }
    
    @RequestMapping(value="/createObsSupervisor",method=RequestMethod.POST,produces="application/json")
    public String saveObsS(@RequestBody Obs_Supervisor obs_Supervisor){
        String jsonObsS = "";
        boolean getresponse = false;
        try {
            getresponse = obs_SupervisorServiceImpl.addObs_Supervisor(obs_Supervisor);
            jsonObsS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObsS;
    }
    
    @RequestMapping(value="/deleteObsSupervisor/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteObs_Supervisor(@PathVariable("id") String id){
        obs_SupervisorServiceImpl.deleteObs_Supervisor(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneObsSupervisor/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Obs_Supervisor getOneObs_Supervisor (@PathVariable("id") String id){
        return obs_SupervisorServiceImpl.getByIdObs_Supervisor(new Long (id));
    }
    
    @RequestMapping(value="/updateObsSupervisor",method=RequestMethod.PUT,produces="application/json")
    public String updateObs_Supervisor(@RequestBody Obs_Supervisor obs_Supervisor){
        String jsonObsS = "";
        boolean getresponse = false;
        try {
            getresponse = obs_SupervisorServiceImpl.updateObs_Supervisor(obs_Supervisor);
            jsonObsS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObsS;
    }

}
