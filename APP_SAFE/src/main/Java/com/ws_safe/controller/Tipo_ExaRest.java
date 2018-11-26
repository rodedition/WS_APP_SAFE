package com.ws_safe.controller;


import com.ws_safe.entity.Tipo_Exa;
import com.ws_safe.service.Tipo_ExaService;
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
@RequestMapping("/tipoExa")
public class Tipo_ExaRest {
    Logger logger = Logger.getLogger(Tipo_ExaRest.class);
    @Autowired
    @Qualifier("tipo_ExaService")
    Tipo_ExaService tipo_ExaServiceImpl;
    
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createTipoExaSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Tipo_Exa> saveTipoExaSP(@RequestBody Tipo_Exa tipo_exa){
        return tipo_ExaServiceImpl.addTipoExaSP(tipo_exa);
    }
    
    @RequestMapping(value="/readOneTipoExa/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Tipo_Exa> readOneTipoExa (@PathVariable("id") String id){
        return tipo_ExaServiceImpl.getByIdTipoExaSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllTipoExa/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Tipo_Exa> getAllTipoExaSP (){
        return tipo_ExaServiceImpl.getAllTipoExaSP();
    }
    
    @RequestMapping(value="/upTipoExa",method=RequestMethod.PUT,produces="application/json")
    public String updateExaSP(@RequestBody Tipo_Exa tipo_Exa){
        String jsonTip = "";
        boolean getresponse = false;
        try {
            getresponse = tipo_ExaServiceImpl.updateTipoExaSP(tipo_Exa);
            jsonTip = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonTip;
    }

    @RequestMapping(value="/deleteTipoExa/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteTipoExaSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        tipo_ExaServiceImpl.deleteTipoExaSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

