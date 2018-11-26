/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Expositor;
import com.ws_safe.service.ExpositorService;
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
@RequestMapping("/expositor")
public class ExpositorRest {
    Logger logger = Logger.getLogger(ExpositorRest.class);
    @Autowired
    @Qualifier("expositorService")
    ExpositorService expositorServiceImpl;
    
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createExpositorSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Expositor> saveExpositorSP(@RequestBody Expositor expositor){
        return expositorServiceImpl.addExpositorSP(expositor);
    }
    
    @RequestMapping(value="/readOneExpositor/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Expositor> readOneExpositor (@PathVariable("id") String id){
        return expositorServiceImpl.getByIdExpositorSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllExpositor/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Expositor> getAllExpositorSP (){
        return expositorServiceImpl.getAllExpositoresSP();
    }
    
    @RequestMapping(value="/upExpositor",method=RequestMethod.PUT,produces="application/json")
    public String updateExpositorSP(@RequestBody Expositor expositor){
        String jsonExpositor = "";
        boolean getresponse = false;
        try {
            getresponse = expositorServiceImpl.updateExpositorSP(expositor);
            jsonExpositor = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExpositor;
    }

    @RequestMapping(value="/deleteExpositor/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteExpositorSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        expositorServiceImpl.deleteExpositorSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
