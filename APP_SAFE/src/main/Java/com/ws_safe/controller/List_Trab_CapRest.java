/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.List_Trab_Cap;
import com.ws_safe.service.List_Trab_CapService;
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
@RequestMapping("/listaTrabajadoresCap")
public class List_Trab_CapRest {
    Logger logger = Logger.getLogger(List_Trab_CapRest.class);
    @Autowired
    @Qualifier("list_Trab_CapService")
    List_Trab_CapService list_Trab_CapServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createListTrabCapSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<List_Trab_Cap> saveListTrabCapSP(@RequestBody List_Trab_Cap list_Trab_Cap){
        return list_Trab_CapServiceImpl.addListTrabCapSP(list_Trab_Cap);
    }
    
    @RequestMapping(value="/readOneListTrabCap/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Trab_Cap> readOneListTrabdCap (@PathVariable("id") String id){
        return list_Trab_CapServiceImpl.getByIdListTrabCapSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllListTrabCap/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Trab_Cap> getAllListTrabCapSP (){
        return list_Trab_CapServiceImpl.getAllListTrabCapSP();
    }
    
    @RequestMapping(value="/upListTrabCap",method=RequestMethod.PUT,produces="application/json")
    public String updateListTrabCapSP(@RequestBody List_Trab_Cap list_Trab_Cap){
        String jsonListTrabC = "";
        boolean getresponse = false;
        try {
            getresponse = list_Trab_CapServiceImpl.updateListTrabCapSP(list_Trab_Cap);
            jsonListTrabC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonListTrabC;
    }

    @RequestMapping(value="/deleteListTrabCap/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteListTrabCapSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        list_Trab_CapServiceImpl.deleteListTrabCapSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
