/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Certificado;
import com.ws_safe.service.CertificadoService;
import com.ws_safe.service.CertificadoServiceImpl;
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

}
