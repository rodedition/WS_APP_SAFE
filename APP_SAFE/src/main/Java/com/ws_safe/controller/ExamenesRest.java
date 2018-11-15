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
    
    //Creación de URIS para llamadas a base de dtos de directa
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getExamenJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonExa="";
        List<Examenes> listExamenes = new ArrayList<Examenes>();        
        try {
            listExamenes = examenesServiceImpl.getListExamen();
            logger.info("La cantidad de examenes son: "+listExamenes.size());
            jsonExa = gson.toJson(listExamenes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExa;
    }
    
    @RequestMapping(value="/createExamen",method=RequestMethod.POST,produces="application/json")
    public String saveExa(@RequestBody Examenes examenes){
        String jsonExa = "";
        boolean getresponse = false;
        try {
            getresponse = examenesServiceImpl.addExamen(examenes);
            jsonExa = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExa;
    }
    
    @RequestMapping(value="/deleteExamen/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteExamen(@PathVariable("id") String id){
        examenesServiceImpl.deleteExamen(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneExamen/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Examenes getOneExamen (@PathVariable("id") String id){
        return examenesServiceImpl.getByIdExamen(new Long (id));
    }
    
    @RequestMapping(value="/updateExamen",method=RequestMethod.PUT,produces="application/json")
    public String updateExamen(@RequestBody Examenes examenes){
        String jsonExa = "";
        boolean getresponse = false;
        try {
            getresponse = examenesServiceImpl.updateExamen(examenes);
            jsonExa = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExa;
    }
    
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
