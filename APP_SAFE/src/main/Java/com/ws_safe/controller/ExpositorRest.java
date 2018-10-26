/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Expositor;
import com.ws_safe.service.ExpositorService;
import com.ws_safe.service.ExpositorServiceImpl;
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
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getExpositorJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonExp="";
        List<Expositor> listExpositor = new ArrayList<Expositor>();        
        try {
            listExpositor = expositorServiceImpl.getListExpositor();
            logger.info("La cantidad de expositores son: "+listExpositor.size());
            jsonExp = gson.toJson(listExpositor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExp;
    }
    
    @RequestMapping(value="/createExpositor",method=RequestMethod.POST,produces="application/json")
    public String saveExp(@RequestBody Expositor expositor){
        String jsonExp = "";
        boolean getresponse = false;
        try {
            getresponse = expositorServiceImpl.addExpositor(expositor);
            jsonExp = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExp;
    }
    
    @RequestMapping(value="/deleteExpositor/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteExpositor(@PathVariable("id") String id){
        expositorServiceImpl.deleteExpositor(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneExpositor/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Expositor getOneExpositor (@PathVariable("id") String id){
        return expositorServiceImpl.getByIdExpositor(new Long (id));
    }
    
    @RequestMapping(value="/updateExpositor",method=RequestMethod.PUT,produces="application/json")
    public String updateExpositor(@RequestBody Expositor expositor){
        String jsonExp = "";
        boolean getresponse = false;
        try {
            getresponse = expositorServiceImpl.updateExpositor(expositor);
            jsonExp = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonExp;
    }

}
