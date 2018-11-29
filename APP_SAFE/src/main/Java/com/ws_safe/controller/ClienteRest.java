/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.ws_safe.entity.Cliente;
import com.ws_safe.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteRest {
    Logger logger = Logger.getLogger(ClienteRest.class);
    @Autowired
    @Qualifier("clienteService")
    ClienteService clienteServiceImpl;
    
    //Creación de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createClienteSP",method=RequestMethod.POST,produces="application/json")
    public @ResponseBody List<Cliente> saveClienteSP(@RequestBody Cliente cliente){
        return clienteServiceImpl.addClienteSP(cliente);
    }
    
    @RequestMapping(value="/readOneCliente/{rut}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Cliente> readOneCliente (@PathVariable("rut") String rut){
        return clienteServiceImpl.getByIdClienteSP(new String (rut));
    }
    
    @RequestMapping(value="/getAllCliente/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Cliente> getAllClienteSP (){
        return clienteServiceImpl.getAllClienteSP();
    }
    
    @RequestMapping(value="/upCliente",method=RequestMethod.PUT,produces="application/json")
    public String updateClienteSP(@RequestBody Cliente cliente){
        String jsonCliente = "";
        boolean getresponse = false;
        try {
            getresponse = clienteServiceImpl.updateClienteSP(cliente);
            jsonCliente = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCliente;
    }

    @RequestMapping(value="/deleteCliente/{rut}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteClienteSP(@PathVariable("rut") String rut, @PathVariable("estado") String estado){
        clienteServiceImpl.deleteClienteSP(new String (rut), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
}
