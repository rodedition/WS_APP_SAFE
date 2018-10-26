/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Eval_Terr;
import com.ws_safe.service.Eval_TerrService;
import com.ws_safe.service.Eval_TerrServiceImpl;
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
@RequestMapping("/evalterr")
public class Eval_TerrRest {
    Logger logger = Logger.getLogger(Eval_TerrRest.class);
    @Autowired
    @Qualifier("eval_TerrService")
    Eval_TerrService eval_TerrServiceImpl;
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getEval_TerrJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonEva="";
        List<Eval_Terr> listEval_Terr = new ArrayList<Eval_Terr>();        
        try {
            listEval_Terr = eval_TerrServiceImpl.getListEval_Terr();
            logger.info("La cantidad de evaluaciones son: "+listEval_Terr.size());
            jsonEva = gson.toJson(listEval_Terr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonEva;
    }
    
    @RequestMapping(value="/createEvalTerreno",method=RequestMethod.POST,produces="application/json")
    public String saveEva(@RequestBody Eval_Terr eval_Terr){
        String jsonEva = "";
        boolean getresponse = false;
        try {
            getresponse = eval_TerrServiceImpl.addEval_Terr(eval_Terr);
            jsonEva = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonEva;
    }
    
    @RequestMapping(value="/deleteEvalTerreno/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteEval_Terr(@PathVariable("id") String id){
        eval_TerrServiceImpl.deleteEval_Terr(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneEvaTerreno/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Eval_Terr getOneEval_Terr (@PathVariable("id") String id){
        return eval_TerrServiceImpl.getByIdEval_Terr(new Long (id));
    }
    
    @RequestMapping(value="/updateEvaTerreno",method=RequestMethod.PUT,produces="application/json")
    public String updateEval_Terr(@RequestBody Eval_Terr eval_Terr){
        String jsonEva = "";
        boolean getresponse = false;
        try {
            getresponse = eval_TerrServiceImpl.updateEval_Terr(eval_Terr);
            jsonEva = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonEva;
    }

}
