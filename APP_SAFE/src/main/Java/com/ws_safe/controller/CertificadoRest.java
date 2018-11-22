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
