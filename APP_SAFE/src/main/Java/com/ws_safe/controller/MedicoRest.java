/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Medico;
import com.ws_safe.service.MedicoService;
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
@RequestMapping("/medico")
public class MedicoRest {
    Logger logger = Logger.getLogger(MedicoRest.class);
    @Autowired
    @Qualifier("medicoService")
    MedicoService medicoServiceImpl;
    
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createMedicoSP",method=RequestMethod.POST,produces="application/json")
    public String saveMedicoSP(@RequestBody Medico medico){
        String jsonMed = "";
        boolean getresponse = false;
        try {
            getresponse = medicoServiceImpl.addMedicoSP(medico);
            jsonMed = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonMed;
    }
    
    @RequestMapping(value="/readOneMedico/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Medico> readOneMedico (@PathVariable("id") String id){
        return medicoServiceImpl.getByIdMedicoSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllMedico/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Medico> getAllMedicoSP (){
        return medicoServiceImpl.getAllMedicoSP();
    }
    
    @RequestMapping(value="/upMedico",method=RequestMethod.PUT,produces="application/json")
    public String updateMedicoSP(@RequestBody Medico medico){
        String jsonMed = "";
        boolean getresponse = false;
        try {
            getresponse = medicoServiceImpl.updateMedicoSP(medico);
            jsonMed = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonMed;
    }

    @RequestMapping(value="/deleteMedico/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteMedicoSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        medicoServiceImpl.deleteMedicoSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
