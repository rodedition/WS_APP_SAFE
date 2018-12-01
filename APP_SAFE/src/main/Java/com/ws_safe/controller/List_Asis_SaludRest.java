/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.List_Asis_Salud;
import com.ws_safe.service.List_Asis_SaludService;
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
@RequestMapping("/listAsisSalud")
public class List_Asis_SaludRest {
    Logger logger = Logger.getLogger(List_Asis_SaludRest.class);
    @Autowired
    @Qualifier("list_Asis_SaludService")
    List_Asis_SaludService list_Asis_SaludServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createListAsisSalud",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<List_Asis_Salud> saveList_Asis_SaludSP(@RequestBody List_Asis_Salud list_Asis_Salud){
        return list_Asis_SaludServiceImpl.addList_Asis_SaludSP(list_Asis_Salud);
    }
    
    @RequestMapping(value="/readOneListAsisSalud/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Asis_Salud> readOneList_Asis_Salud (@PathVariable("id") String id){
        return list_Asis_SaludServiceImpl.getByIdList_Asis_SaludSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllListAsisSalud/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<List_Asis_Salud> getAllList_Asis_SaludSP (){
        return list_Asis_SaludServiceImpl.getAllList_Asis_SaludSP();
    }
    
    @RequestMapping(value="/upListAsisSalud",method=RequestMethod.PUT,produces="application/json")
    public String updateList_Asis_SaludSP(@RequestBody List_Asis_Salud list_Asis_Salud){
        String jsonLists = "";
        boolean getresponse = false;
        try {
            getresponse = list_Asis_SaludServiceImpl.updateList_Asis_SaludSP(list_Asis_Salud);
            jsonLists = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonLists;
    }

    @RequestMapping(value="/deleteListAsisSalud/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteListAsisSaludSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        list_Asis_SaludServiceImpl.deleteList_Asis_SaludSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
