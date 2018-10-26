/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.SoliEvalTer;
import com.ws_safe.service.SoliEvalTerService;
import com.ws_safe.service.SoliEvalTerServiceImpl;
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
@RequestMapping("/SolicitudEvalTerreno")
public class SoliEvalTerRest {
    Logger logger = Logger.getLogger(SoliEvalTerRest.class);
    @Autowired
    @Qualifier("soliEvalTerService")
    SoliEvalTerService soliEvalTerServiceImpl;
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getSoliEvalTerJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonSol="";
        List<SoliEvalTer> listSoliEvalTer = new ArrayList<SoliEvalTer>();        
        try {
            listSoliEvalTer = soliEvalTerServiceImpl.getListSoliEvalTer();
            logger.info("La cantidad de solicitudes son: "+listSoliEvalTer.size());
            jsonSol = gson.toJson(listSoliEvalTer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSol;
    }
    
    @RequestMapping(value="/createSoliEvalTer",method=RequestMethod.POST,produces="application/json")
    public String saveSol(@RequestBody SoliEvalTer soliEvalTer){
        String jsonSol = "";
        boolean getresponse = false;
        try {
            getresponse = soliEvalTerServiceImpl.addSoliEvalTer(soliEvalTer);
            jsonSol = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSol;
    }
    
    @RequestMapping(value="/deleteSoliEvalTer/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteSoliEvalTer(@PathVariable("id") String id){
        soliEvalTerServiceImpl.deleteSoliEvalTer(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneSoliEvalTer/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody SoliEvalTer getOneSoliEvalTer (@PathVariable("id") String id){
        return soliEvalTerServiceImpl.getByIdSoliEvalTer(new Long (id));
    }
    
    @RequestMapping(value="/updateSoliEvalTer",method=RequestMethod.PUT,produces="application/json")
    public String updateSoliEvalTer(@RequestBody SoliEvalTer soliEvalTer){
        String jsonSol = "";
        boolean getresponse = false;
        try {
            getresponse = soliEvalTerServiceImpl.updateSoliEvalTer(soliEvalTer);
            jsonSol = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSol;
    }

}
