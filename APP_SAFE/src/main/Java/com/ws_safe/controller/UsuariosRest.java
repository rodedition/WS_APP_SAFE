/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.controller;

import com.google.gson.Gson;
import com.ws_safe.entity.Usuarios;
import com.ws_safe.service.UsuariosService;
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
@RequestMapping("/usuarios")
public class UsuariosRest {
    Logger logger = Logger.getLogger(UsuariosRest.class);
    @Autowired
    @Qualifier("usuariosService")
    UsuariosService usuariosServiceImpl;
    
    @RequestMapping(value="/createUsuarioSP",method=RequestMethod.POST,produces="application/json")
    public String saveUsuarioSP(@RequestBody Usuarios usuarios){
        String jsonUsu = "";
        boolean getresponse = false;
        try {
            getresponse = usuariosServiceImpl.addUsuarioSP(usuarios);
            jsonUsu = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonUsu;
    }
    
    @RequestMapping(value="/readOneUsuario/{rut}", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Usuarios> readOneMedico (@PathVariable("rut") String rut){
        return usuariosServiceImpl.getByIdUsuarioSP(new String (rut));
    }
    
    @RequestMapping(value="/getAllUsuarios/", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Usuarios> getAllUsuriosSP (){
        return usuariosServiceImpl.getAllUsuarioSP();
    }
    
    @RequestMapping(value="/upUsuario",method=RequestMethod.PUT,produces="application/json")
    public String updateUsurioSP(@RequestBody Usuarios usuarios){
        String jsonUsu = "";
        boolean getresponse = false;
        try {
            getresponse = usuariosServiceImpl.updateUsuarioSP(usuarios);
            jsonUsu = getresponse==true?"1":"0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonUsu;
    }

    @RequestMapping(value="/deleteMedico/{rut}/{estado}",method=RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Void> deleteUsurioSP(@PathVariable("rut") String rut, @PathVariable("estado") String estado){
        usuariosServiceImpl.deleteUsuarioSP(new String (rut), new Long (estado));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
