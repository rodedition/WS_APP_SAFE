/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Sesion_Salud;
import com.ws_safe.service.Sesion_SaludService;
import com.ws_safe.service.Sesion_SaludServiceImpl;
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
@RequestMapping("/sesionSalud")
public class Sesion_SaludRest {
    Logger logger = Logger.getLogger(Sesion_SaludRest.class);
    @Autowired
    @Qualifier("sesion_SaludService")
    Sesion_SaludService sesion_SaludServiceImpl;
    
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createSesionSaludSP",method=RequestMethod.POST,produces="application/json")
    public String saveSesionSaludSP(@RequestBody Sesion_Salud sesion_Salud){
        String jsonSes = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_SaludServiceImpl.addSesionSaludSP(sesion_Salud);
            jsonSes = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSes;
    }
    
    @RequestMapping(value="/readOneSesionSalud/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Sesion_Salud> readOneSesionSalud (@PathVariable("id") String id){
        return sesion_SaludServiceImpl.getByIdSesionSaludSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllSesionSalud/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Sesion_Salud> getAllSesionSaludSP (){
        return sesion_SaludServiceImpl.getAllSesionSaludSP();
    }
    
    @RequestMapping(value="/upSesionSalud",method=RequestMethod.PUT,produces="application/json")
    public String updateSesionSaludSP(@RequestBody Sesion_Salud sesion_Salud){
        String jsonSes = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_SaludServiceImpl.updateSesionSaludSP(sesion_Salud);
            jsonSes = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSes;
    }

    @RequestMapping(value="/deleteSesionSalud/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteSesionSaludSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        sesion_SaludServiceImpl.deleteSesionSaludSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
