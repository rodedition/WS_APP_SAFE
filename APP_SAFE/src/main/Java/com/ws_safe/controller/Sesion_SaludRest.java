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
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getSesion_SaludJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonSesS="";
        List<Sesion_Salud> listSesion_Salud = new ArrayList<Sesion_Salud>();        
        try {
            listSesion_Salud = sesion_SaludServiceImpl.getListSesion_Salud();
            logger.info("La cantidad de sesiones son: "+listSesion_Salud.size());
            jsonSesS = gson.toJson(listSesion_Salud);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesS;
    }
    
    @RequestMapping(value="/createSesionSalud",method=RequestMethod.POST,produces="application/json")
    public String saveSesS(@RequestBody Sesion_Salud sesion_Salud){
        String jsonSesS = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_SaludServiceImpl.addSesion_Salud(sesion_Salud);
            jsonSesS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesS;
    }
    
    @RequestMapping(value="/deleteSesionSalud/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteSesion_Salud(@PathVariable("id") String id){
        sesion_SaludServiceImpl.deleteSesion_Salud(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneSesionSalud/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Sesion_Salud getOneSesion_Salud (@PathVariable("id") String id){
        return sesion_SaludServiceImpl.getByIdSesion_Salud(new Long (id));
    }
    
    @RequestMapping(value="/updateSesionSalud",method=RequestMethod.PUT,produces="application/json")
    public String updateSesion_Salud(@RequestBody Sesion_Salud sesion_Salud){
        String jsonSesS = "";
        boolean getresponse = false;
        try {
            getresponse = sesion_SaludServiceImpl.updateSesion_Salud(sesion_Salud);
            jsonSesS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonSesS;
    }

}
