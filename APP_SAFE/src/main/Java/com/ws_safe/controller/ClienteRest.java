/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Cliente;
import com.ws_safe.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteRest {
    Logger logger = Logger.getLogger(ClienteRest.class);
    @Autowired
    @Qualifier("clienteService")
    ClienteService clienteServiceImpl;
    
    //Creaci�n de URIS para llamadas a base de dtos de directa
    
    @RequestMapping(value="/{name}", method=RequestMethod.GET,produces="application/json")
    public String getClienteJSON(@PathVariable String name){
        Gson gson = new Gson();
        
        String jsonCliente="";
        List<Cliente> listCliente = new ArrayList<Cliente>();        
        try {
            listCliente = clienteServiceImpl.getListCliente();
            logger.info("La cantidad de clientes son: "+listCliente.size());
            jsonCliente = gson.toJson(listCliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCliente;
    }
    
    @RequestMapping(value="/createCliente",method=RequestMethod.POST,produces="application/json")
    public String saveCliente(@RequestBody Cliente cliente){
        String jsonCliente = "";
        boolean getresponse = false;
        try {
            getresponse = clienteServiceImpl.addCliente(cliente);
            jsonCliente = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCliente;
    }
    
    @RequestMapping(value="/deleteCliente/{id}",method=RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") String id){
        clienteServiceImpl.deleteCliente(new Long (id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
    @RequestMapping(value="/getOneCliente/{id}", method=RequestMethod.GET,produces="application/json")
    public @ResponseBody Cliente getOneCliente (@PathVariable("id") Long id){
        return clienteServiceImpl.getByIdCliente(new Long (id));
    }
    
    @RequestMapping(value="/updateCliente",method=RequestMethod.PUT,produces="application/json")
    public String updateCliente(@RequestBody Cliente cliente){
        String jsonCliente = "";
        boolean getresponse = false;
        try {
            getresponse = clienteServiceImpl.updateCliente(cliente);
            jsonCliente = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCliente;
    }
    
    //Creaci�n de URIS para llamadas a PROCEDURE
    
    @RequestMapping(value="/createClienteSP",method=RequestMethod.POST,produces="application/json")
    public String saveClienteSP(@RequestBody Cliente cliente){
        String jsonCliente = "";
        boolean getresponse = false;
        try {
            getresponse = clienteServiceImpl.addClienteSP(cliente);
            jsonCliente = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonCliente;
    }
    
    @RequestMapping(value="/readOneCliente/{id}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Cliente> readOneCliente (@PathVariable("id") String id){
        return clienteServiceImpl.getByIdClienteSP(new Long (id));
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

    @RequestMapping(value="/deleteCliente/{id}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteClienteSP(@PathVariable("id") String id, @PathVariable("estado") String estado){
        clienteServiceImpl.deleteClienteSP(new Long (id), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    } 
    
}
