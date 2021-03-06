/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Obs_Ingeniero;
import com.ws_safe.service.Obs_IngenieroService;
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
@RequestMapping("/obsIngeniero")
public class Obs_IngenieroRest {
    Logger logger = Logger.getLogger(Obs_IngenieroRest.class);
    @Autowired
    @Qualifier("obs_IngenieroService")
    Obs_IngenieroService obs_IngenieroServiceImpl;
    
    
    
    //Creaci�n de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createObsIngSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Obs_Ingeniero> saveObsIngSP(@RequestBody Obs_Ingeniero obs_Ingeniero){
        return obs_IngenieroServiceImpl.addObsIngSP(obs_Ingeniero);
    }
    
    @RequestMapping(value="/readOneObsIng/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Obs_Ingeniero> readOneObsIng (@PathVariable("id") String id){
        return obs_IngenieroServiceImpl.getByIdObsIngSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllObsIng/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Obs_Ingeniero> getAllObsIngSP (){
        return obs_IngenieroServiceImpl.getAllObsIngSP();
    }
    
    @RequestMapping(value="/upObsIng",method=RequestMethod.PUT,produces="application/json")
    public String updateObsIngSP(@RequestBody Obs_Ingeniero obs_Ingeniero){
        String jsonObs = "";
        boolean getresponse = false;
        try {
            getresponse = obs_IngenieroServiceImpl.updateObsIngSP(obs_Ingeniero);
            jsonObs = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObs;
    }

    @RequestMapping(value="/deleteObsIng/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteObsIngSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        obs_IngenieroServiceImpl.deleteObsIngSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
