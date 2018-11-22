/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.ListTrabSalud;
import com.ws_safe.service.ListTrabSaludService;
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
@RequestMapping("/listaTrabajadoresSalud")
public class ListTrabSaludRest {
    Logger logger = Logger.getLogger(ListTrabSaludRest.class);
    @Autowired
    @Qualifier("listTrabSaludService")
    ListTrabSaludService listTrabSaludServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createListTrabSaludSP",method=RequestMethod.POST,produces="application/json")
    public String saveListTrabSaludSP(@RequestBody ListTrabSalud listTrabSalud){
        String jsonListTrabS = "";
        boolean getresponse = false;
        try {
            getresponse = listTrabSaludServiceImpl.addListTrabSaludSP(listTrabSalud);
            jsonListTrabS = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonListTrabS;
    }
    
    @RequestMapping(value="/readOneListTrabSalud/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<ListTrabSalud> readOneListTrabdSalud (@PathVariable("id") String id){
        return listTrabSaludServiceImpl.getByIdListTrabSaludSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllListTrabSalud/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<ListTrabSalud> getAllListTrabSaludSP (){
        return listTrabSaludServiceImpl.getAllListTrabSaludSP();
    }
    
    @RequestMapping(value="/upListTrabSalud",method=RequestMethod.PUT,produces="application/json")
    public String updateListTrabSaludSP(@RequestBody ListTrabSalud listTrabSalud){
        String jsonListTrabs = "";
        boolean getresponse = false;
        try {
            getresponse = listTrabSaludServiceImpl.updateListTrabSaludSP(listTrabSalud);
            jsonListTrabs = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonListTrabs;
    }

    @RequestMapping(value="/deleteListTrabSalud/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteListTrabSaludSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        listTrabSaludServiceImpl.deleteListTrabSaludSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
