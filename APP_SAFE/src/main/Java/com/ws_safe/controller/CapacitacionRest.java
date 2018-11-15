/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Capacitacion;
import com.ws_safe.service.CapacitacionService;
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
@RequestMapping("/capacitacion")
public class CapacitacionRest {
    Logger logger = Logger.getLogger(CapacitacionRest.class);
    @Autowired
    @Qualifier("capacitacionService")
    CapacitacionService capacitacionServiceImpl;
    
    //Creación de URIS para llamadas a base de dtos de directa
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getCapJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonCap="";
        List<Capacitacion> listCapacitacion = new ArrayList<Capacitacion>();        
        try {
            listCapacitacion = capacitacionServiceImpl.getListCapacitacion();
            logger.info("La cantidad de cap son: "+listCapacitacion.size());
            jsonCap = gson.toJson(listCapacitacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCap;
    }
    
    @RequestMapping(value="/createCapacitacion",method=RequestMethod.POST,produces="application/json")
    public String saveCap(@RequestBody Capacitacion capacitacion){
        String jsonCap = "";
        boolean getresponse = false;
        try {
            getresponse = capacitacionServiceImpl.addCap(capacitacion);
            jsonCap = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCap;
    }
    
    @RequestMapping(value="/deleteCapacitacion/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteCap(@PathVariable("id") String id){
        capacitacionServiceImpl.deleteCap(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneCapacitacion/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Capacitacion getOneCap (@PathVariable("id") String id){
        return capacitacionServiceImpl.getByIdCap(new Long (id));
    }
    
    @RequestMapping(value="/updateCapacitacion",method=RequestMethod.PUT,produces="application/json")
    public String updateCap(@RequestBody Capacitacion capacitacion){
        String jsonCap = "";
        boolean getresponse = false;
        try {
            getresponse = capacitacionServiceImpl.updateCap(capacitacion);
            jsonCap = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCap;
    }
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createCapacitacionSP",method=RequestMethod.POST,produces="application/json")
    public String saveCapacitacionSP(@RequestBody Capacitacion capacitacion){
        String jsonCapacitacion = "";
        boolean getresponse = false;
        try {
            getresponse = capacitacionServiceImpl.addCapacitacionSP(capacitacion);
            jsonCapacitacion = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCapacitacion;
    }
    
    @RequestMapping(value="/readOneCapacitacion/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Capacitacion> readOneCapacitacion (@PathVariable("id") String id){
        return capacitacionServiceImpl.getByIdCapacitacionSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllCapacitacion/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Capacitacion> getAllCapacitacionSP (){
        return capacitacionServiceImpl.getAllCapacitacionSP();
    }
    
    @RequestMapping(value="/upCapacitacion",method=RequestMethod.PUT,produces="application/json")
    public String updateCapacitacionSP(@RequestBody Capacitacion capacitacion){
        String jsonCapacitacion = "";
        boolean getresponse = false;
        try {
            getresponse = capacitacionServiceImpl.updateCap(capacitacion);
            jsonCapacitacion = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCapacitacion;
    }

    @RequestMapping(value="/deleteCapacitacion/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteCapacitacionSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        capacitacionServiceImpl.deleteCapacitacionSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 


}
