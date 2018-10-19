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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    //agregar cliente
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
}
