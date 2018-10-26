/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.ListTrabSalud;
import com.ws_safe.service.ListTrabSaludService;
import com.ws_safe.service.ListTrabSaludServiceImpl;
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
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getListTrabSaludJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonList="";
        List<ListTrabSalud> listListTrabSalud = new ArrayList<ListTrabSalud>();        
        try {
            listListTrabSalud = listTrabSaludServiceImpl.getListListTrabSalud();
            logger.info("La cantidad de listas son: "+listListTrabSalud.size());
            jsonList = gson.toJson(listListTrabSalud);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }
    
    @RequestMapping(value="/createListaTrabajadoresSalud",method=RequestMethod.POST,produces="application/json")
    public String saveList(@RequestBody ListTrabSalud listTrabSalud){
        String jsonList = "";
        boolean getresponse = false;
        try {
            getresponse = listTrabSaludServiceImpl.addListTrabSalud(listTrabSalud);
            jsonList = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }
    
    @RequestMapping(value="/deleteListaTrabajadoresSalud/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteListTrabSalud(@PathVariable("id") String id){
        listTrabSaludServiceImpl.deleteListTrabSalud(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneListaTrabajadoresSalud/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody ListTrabSalud getOneListTrabSalud (@PathVariable("id") String id){
        return listTrabSaludServiceImpl.getByIdListTrabSalud(new Long (id));
    }
    
    @RequestMapping(value="/updateListaTrabajadoresSalud",method=RequestMethod.PUT,produces="application/json")
    public String updateListTrabSalud(@RequestBody ListTrabSalud listTrabSalud){
        String jsonList = "";
        boolean getresponse = false;
        try {
            getresponse = listTrabSaludServiceImpl.updateListTrabSalud(listTrabSalud);
            jsonList = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }

}
