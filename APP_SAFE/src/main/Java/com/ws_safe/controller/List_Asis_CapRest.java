/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.List_Asis_Cap;
import com.ws_safe.service.List_Asis_CapService;
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
@RequestMapping("/listAsisCap")
public class List_Asis_CapRest {
    Logger logger = Logger.getLogger(List_Asis_CapRest.class);
    @Autowired
    @Qualifier("list_Asis_CapService")
    List_Asis_CapService list_Asis_CapServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createListAsisCap",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<List_Asis_Cap> saveList_Asis_CapSP(@RequestBody List_Asis_Cap list_Asis_Cap){
        return list_Asis_CapServiceImpl.addList_Asis_CapSP(list_Asis_Cap);
    }
    
    @RequestMapping(value="/readOneListAsisCap/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Asis_Cap> readOneList_Asis_Cap (@PathVariable("id") String id){
        return list_Asis_CapServiceImpl.getByIdList_Asis_CapSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllListAsisCap/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Asis_Cap> getAllList_Asis_CapSP (){
        return list_Asis_CapServiceImpl.getAllList_Asis_CapSP();
    }
    
    @RequestMapping(value="/upListAsisCap",method=RequestMethod.PUT,produces="application/json")
    public String updateList_Asis_CapSP(@RequestBody List_Asis_Cap list_Asis_Cap){
        String jsonLists = "";
        boolean getresponse = false;
        try {
            getresponse = list_Asis_CapServiceImpl.updateList_Asis_CapSP(list_Asis_Cap);
            jsonLists = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonLists;
    }

    @RequestMapping(value="/deleteListAsisCap/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteListAsisCapSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        list_Asis_CapServiceImpl.deleteList_Asis_CapSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
