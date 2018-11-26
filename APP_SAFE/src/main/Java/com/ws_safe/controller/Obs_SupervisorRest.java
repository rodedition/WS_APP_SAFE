/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Obs_Supervisor;
import com.ws_safe.service.Obs_SupervisorService;
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
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createObsSupSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Obs_Supervisor> saveObsSupSP(@RequestBody Obs_Supervisor obs_Supervisor){
        return obs_SupervisorServiceImpl.addObsSupSP(obs_Supervisor);
    }
    
    @RequestMapping(value="/readOneObsSup/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Obs_Supervisor> readOneObsSup (@PathVariable("id") String id){
        return obs_SupervisorServiceImpl.getByIdObsSupSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllObsSup/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Obs_Supervisor> getAllObsSupSP (){
        return obs_SupervisorServiceImpl.getAllObsSupSP();
    }
    
    @RequestMapping(value="/upObsSup",method=RequestMethod.PUT,produces="application/json")
    public String updateObsSupSP(@RequestBody Obs_Supervisor obs_Supervisor){
        String jsonObs = "";
        boolean getresponse = false;
        try {
            getresponse = obs_SupervisorServiceImpl.updateObsSupSP(obs_Supervisor);
            jsonObs = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObs;
    }

    @RequestMapping(value="/deleteObsSup/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteObsSupSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        obs_SupervisorServiceImpl.deleteObsSupSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
