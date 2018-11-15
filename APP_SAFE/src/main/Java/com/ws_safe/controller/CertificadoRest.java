/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Certificado;
import com.ws_safe.service.CertificadoService;
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
@RequestMapping("/certificado")
public class CertificadoRest {
    Logger logger = Logger.getLogger(CertificadoRest.class);
    @Autowired
    @Qualifier("certificadoService")
    CertificadoService certificadoServiceImpl;
    
    //Creación de URIS para llamadas a base de dtos de directa
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getCertificadoJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonCer="";
        List<Certificado> listCertificado = new ArrayList<Certificado>();        
        try {
            listCertificado = certificadoServiceImpl.getListCertificado();
            logger.info("La cantidad de certificado son: "+listCertificado.size());
            jsonCer = gson.toJson(listCertificado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCer;
    }
    
    @RequestMapping(value="/createCertificado",method=RequestMethod.POST,produces="application/json")
    public String saveCer(@RequestBody Certificado certificado){
        String jsonCer = "";
        boolean getresponse = false;
        try {
            getresponse = certificadoServiceImpl.addCertificado(certificado);
            jsonCer = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCer;
    }   
    
    @RequestMapping(value="/deleteCertificado/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteCertificado(@PathVariable("id") String id){
        certificadoServiceImpl.deleteCertificado(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneCertificado/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Certificado getOneCertificado (@PathVariable("id") String id){
        return certificadoServiceImpl.getByIdCertificado(new Long (id));
    }
    
    @RequestMapping(value="/updateCertificado",method=RequestMethod.PUT,produces="application/json")
    public String updateCertificado(@RequestBody Certificado certificado){
        String jsonCer = "";
        boolean getresponse = false;
        try {
            getresponse = certificadoServiceImpl.updateCertificado(certificado);
            jsonCer = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCer;
    }
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createCertificadoSP",method=RequestMethod.POST,produces="application/json")
    public String saveCertificadoSP(@RequestBody Certificado certificado){
        String jsonCertificado = "";
        boolean getresponse = false;
        try {
            getresponse = certificadoServiceImpl.addCertificadoSP(certificado);
            jsonCertificado = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCertificado;
    }
    
    @RequestMapping(value="/readOneCertificado/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Certificado> readOneCertificado (@PathVariable("id") String id){
        return certificadoServiceImpl.getByIdCertificadoSP(new Long (id));
    }
    
    @RequestMapping(value="/getAllCertificado/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Certificado> getAllCertificadoSP (){
        return certificadoServiceImpl.getAllCertificadoSP();
    }
    
    @RequestMapping(value="/upCertificado",method=RequestMethod.PUT,produces="application/json")
    public String updateCertificadoSP(@RequestBody Certificado certificado){
        String jsonCertificado = "";
        boolean getresponse = false;
        try {
            getresponse = certificadoServiceImpl.updateCertificadoSP(certificado);
            jsonCertificado = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCertificado;
    }

    @RequestMapping(value="/deleteCertificado/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteCertificadoSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        certificadoServiceImpl.deleteCertificadoSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 

}
