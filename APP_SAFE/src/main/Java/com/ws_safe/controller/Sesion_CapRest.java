/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Sesion_Cap;
import com.ws_safe.service.Sesion_CapService;
import com.ws_safe.service.Sesion_CapServiceImpl;
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
@RequestMapping("/sesionCap")
public class Sesion_CapRest {
    Logger logger = Logger.getLogger(Sesion_CapRest.class);
    @Autowired
    @Qualifier("sesion_CapService")
    Sesion_CapService sesion_CapServiceImpl;
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getSesion_CapJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonSesC="";
        List<Sesion_Cap> listSesion_Cap = new ArrayList<Sesion_Cap>();        
        try {
            listSesion_Cap = sesion_CapServiceImpl.getListSesion_Cap();
            logger.info("La cantidad de sesiones son: "+listSesion_Cap.size());
            jsonSesC = gson.toJson(listSesion_Cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesC;
    }
    
    @RequestMapping(value="/createSesionCap",method=RequestMethod.POST,produces="application/json")
    public String saveSesC(@RequestBody Sesion_Cap sesion_Cap){
        String jsonSesC = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_CapServiceImpl.addSesion_Cap(sesion_Cap);
            jsonSesC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesC;
    }
    
    @RequestMapping(value="/deleteSesionCap/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteSesion_Cap(@PathVariable("id") String id){
        sesion_CapServiceImpl.deleteSesion_Cap(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneSesionCap/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Sesion_Cap getOneSesion_Cap (@PathVariable("id") String id){
        return sesion_CapServiceImpl.getByIdSesion_Cap(new Long (id));
    }
    
    @RequestMapping(value="/updateSesionCap",method=RequestMethod.PUT,produces="application/json")
    public String updateSesion_Cap(@RequestBody Sesion_Cap sesion_Cap){
        String jsonSesC = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_CapServiceImpl.updateSesion_Cap(sesion_Cap);
            jsonSesC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesC;
    }

}
