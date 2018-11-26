package com.ws_safe.controller;


import com.ws_safe.entity.Tipo_Cap;
import com.ws_safe.service.Tipo_CapService;
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
@RequestMapping("/tipoCap")
public class Tipo_CapRest {
    Logger logger = Logger.getLogger(Tipo_CapRest.class);
    @Autowired
    @Qualifier("tipo_CapService")
    Tipo_CapService tipo_CapServiceImpl;
    
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createTipoCapSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Tipo_Cap> saveTipoCapSP(@RequestBody Tipo_Cap tipo_cap){
        return tipo_CapServiceImpl.addTipoCapSP(tipo_cap);
    }
    
    @RequestMapping(value="/readOneTipoCap/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Tipo_Cap> readOneTipoCap (@PathVariable("id") String id){
        return tipo_CapServiceImpl.getByIdTipoCapSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllTipoCap/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Tipo_Cap> getAllTipoCapSP (){
        return tipo_CapServiceImpl.getAllTipoCapSP();
    }
    
    @RequestMapping(value="/upTipoCap",method=RequestMethod.PUT,produces="application/json")
    public String updateCapSP(@RequestBody Tipo_Cap tipo_Cap){
        String jsonTip = "";
        boolean getresponse = false;
        try {
            getresponse = tipo_CapServiceImpl.updateTipoCapSP(tipo_Cap);
            jsonTip = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonTip;
    }

    @RequestMapping(value="/deleteTipoCap/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteTipoCapSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        tipo_CapServiceImpl.deleteTipoCapSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

