/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Eval_Terr;
import com.ws_safe.service.Eval_TerrService;
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
@RequestMapping("/evalTerreno")
public class Eval_TerrRest {
    Logger logger = Logger.getLogger(Eval_TerrRest.class);
    @Autowired
    @Qualifier("eval_TerrService")
    Eval_TerrService eval_TerrServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createEvalTerrenoSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Eval_Terr> saveEval_TerrSP(@RequestBody Eval_Terr eval_Terr){
        return eval_TerrServiceImpl.addEval_TerrSP(eval_Terr);
    }
    
    @RequestMapping(value="/readOneEvalTerreno/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Eval_Terr> readOneEval_Terr (@PathVariable("id") String id){
        return eval_TerrServiceImpl.getByIdEval_TerrSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllEvalTerreno/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Eval_Terr> getAllEval_TerrSP (){
        return eval_TerrServiceImpl.getAllEval_TerrSP();
    }
    
    @RequestMapping(value="/upEvalTerreno",method=RequestMethod.PUT,produces="application/json")
    public String updateEval_TerrSP(@RequestBody Eval_Terr eval_Terr){
        String jsonEval = "";
        boolean getresponse = false;
        try {
            getresponse = eval_TerrServiceImpl.updateEval_TerrSP(eval_Terr);
            jsonEval = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonEval;
    }

    @RequestMapping(value="/deleteEvalTerreno/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteEval_TerrSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        eval_TerrServiceImpl.deleteEval_TerrSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
}
