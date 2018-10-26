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

   
    public List<Usuarios> getListUsuarios() {
        return usuariosDAOImpl.getListUsuarios();
    }

   
    public boolean addUsuarios(Usuarios usuarios) {
        return usuariosDAOImpl.addUsuarios(usuarios);
    }

    public Usuarios getByIdUsuarios(Long id) {
        return usuariosDAOImpl.getByIdUsuarios(id);
    }

    public void deleteUsuarios(Long id) {
        usuariosDAOImpl.deleteUsuarios(id);
    }

    public boolean updateUsuarios(Usuarios usuarios) {
        return usuariosDAOImpl.updateUsuarios(usuarios);
    }    
    
}
