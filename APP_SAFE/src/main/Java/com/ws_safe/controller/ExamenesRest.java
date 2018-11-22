/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Examenes;
import com.ws_safe.service.ExamenesService;
import com.ws_safe.service.ExamenesServiceImpl;
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
@RequestMapping("/examenes")
public class ExamenesRest {
    Logger logger = Logger.getLogger(ExamenesRest.class);
    @Autowired
    @Qualifier("examenesService")
    ExamenesService examenesServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createExamenSP",method=RequestMethod.POST,produces="application/json")
    public String saveExamenSP(@RequestBody Examenes examenes){
        String jsonExamen = "";
        boolean getresponse = false;
        try {
            getresponse = examenesServiceImpl.addExamenSP(examenes);
            jsonExamen = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExamen;
    }
    
    @RequestMapping(value="/readOneExamen/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Examenes> readOneExamen (@PathVariable("id") String id){
        return examenesServiceImpl.getByIdExamenSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllExamenes/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Examenes> getAllExamenesSP (){
        return examenesServiceImpl.getAllExamenesSP();
    }
    
    @RequestMapping(value="/upExamen",method=RequestMethod.PUT,produces="application/json")
    public String updateExamenSP(@RequestBody Examenes examenes){
        String jsonExamen = "";
        boolean getresponse = false;
        try {
            getresponse = examenesServiceImpl.updateExamenSP(examenes);
            jsonExamen = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExamen;
    }

    @RequestMapping(value="/deleteExamenes/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteExamenesSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        examenesServiceImpl.deleteExamenSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
