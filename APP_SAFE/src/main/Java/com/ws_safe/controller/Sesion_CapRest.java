/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Sesion_Cap;
import com.ws_safe.service.Sesion_CapService;
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
@RequestMapping("/sesionCap")
public class Sesion_CapRest {
    Logger logger = Logger.getLogger(Sesion_CapRest.class);
    @Autowired
    @Qualifier("sesion_CapService")
    Sesion_CapService sesion_CapServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createSesionCapSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Sesion_Cap> saveSesionCapSP(@RequestBody Sesion_Cap sesion_Cap){
        return sesion_CapServiceImpl.addSesionCapSP(sesion_Cap);
    }
    
    @RequestMapping(value="/readOneSesionCap/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Sesion_Cap> readOneSesionCap (@PathVariable("id") String id){
        return sesion_CapServiceImpl.getByIdSesionCapSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllSesionCap/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Sesion_Cap> getAllSesionCapSP (){
        return sesion_CapServiceImpl.getAllSesionCapSP();
    }
    
    @RequestMapping(value="/upSesionCap",method=RequestMethod.PUT,produces="application/json")
    public String updateSesionCapSP(@RequestBody Sesion_Cap sesion_Cap){
        String jsonSes = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_CapServiceImpl.updateSesionCapSP(sesion_Cap);
            jsonSes = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSes;
    }

    @RequestMapping(value="/deleteSesionCap/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteSesionCapSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        sesion_CapServiceImpl.deleteSesionCapSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
