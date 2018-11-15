/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.List_Trab_Cap;
import com.ws_safe.service.List_Trab_CapService;
import com.ws_safe.service.List_Trab_CapServiceImpl;
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
@RequestMapping("/listaTrabajadoresCap")
public class List_Trab_CapRest {
    Logger logger = Logger.getLogger(List_Trab_CapRest.class);
    @Autowired
    @Qualifier("list_Trab_CapService")
    List_Trab_CapService list_Trab_CapServiceImpl;
    
    //Creación de URIS para llamadas a base de dtos de directa
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getList_Trab_CapJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonList="";
        List<List_Trab_Cap> listList_Trab_Cap = new ArrayList<List_Trab_Cap>();        
        try {
            listList_Trab_Cap = list_Trab_CapServiceImpl.getListList_Trab_Cap();
            logger.info("La cantidad de listas son: "+listList_Trab_Cap.size());
            jsonList = gson.toJson(listList_Trab_Cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }
    
    @RequestMapping(value="/createListaTrabajadoresCap",method=RequestMethod.POST,produces="application/json")
    public String saveList(@RequestBody List_Trab_Cap list_Trab_Cap){
        String jsonList = "";
        boolean getresponse = false;
        try {
            getresponse = list_Trab_CapServiceImpl.addList_Trab_Cap(list_Trab_Cap);
            jsonList = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }
    
    @RequestMapping(value="/deleteListaTrabajadoresCap/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteList_Trab_Cap(@PathVariable("id") String id){
        list_Trab_CapServiceImpl.deleteList_Trab_Cap(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneListaTrabajadoresCap/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody List_Trab_Cap getOneList_Trab_Cap (@PathVariable("id") String id){
        return list_Trab_CapServiceImpl.getByIdList_Trab_Cap(new Long (id));
    }
    
    @RequestMapping(value="/updateListaTrabajadoresCap",method=RequestMethod.PUT,produces="application/json")
    public String updateList_Trab_Cap(@RequestBody List_Trab_Cap list_Trab_Cap){
        String jsonList = "";
        boolean getresponse = false;
        try {
            getresponse = list_Trab_CapServiceImpl.updateList_Trab_Cap(list_Trab_Cap);
            jsonList = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createListTrabCapSP",method=RequestMethod.POST,produces="application/json")
    public String saveListTrabCapSP(@RequestBody List_Trab_Cap list_Trab_Cap){
        String jsonListTrabC = "";
        boolean getresponse = false;
        try {
            getresponse = list_Trab_CapServiceImpl.addListTrabCapSP(list_Trab_Cap);
            jsonListTrabC = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonListTrabC;
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
