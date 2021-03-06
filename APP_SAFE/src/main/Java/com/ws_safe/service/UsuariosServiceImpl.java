/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.UsuariosDAO;
import com.ws_safe.entity.Usuarios;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("usuariosService")
public class UsuariosServiceImpl implements UsuariosService{
    
    Logger logger = Logger.getLogger(UsuariosServiceImpl.class);
    
    @Autowired
    @Qualifier("usuariosDAO")
    
    UsuariosDAO usuariosDAOImpl;
    
       
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Usuarios> addUsuarioSP(Usuarios usuarios) {
        return usuariosDAOImpl.addUsuarioSP(usuarios);
    }

    @Override
    public List<Usuarios> getByIdUsuarioSP(String rut) {
        return usuariosDAOImpl.getByIdUsuarioSP(rut);
    }

    @Override
    public List<Usuarios> getAllUsuarioSP() {
        return usuariosDAOImpl.getAllUsuarioSP();
    }

    @Override
    public boolean updateUsuarioSP(Usuarios usuarios) {
        return usuariosDAOImpl.updateUsuarioSP(usuarios);
    }

    @Override
    public void deleteUsuarioSP(String run, Long estado) {
        usuariosDAOImpl.deleteUsuarioSP(run, estado);
    }

    @Override
    public List<Usuarios> loginUsuarioSP(Usuarios usuarios) {
        return usuariosDAOImpl.loginUsuarioSP(usuarios);
    }
    
    
}
