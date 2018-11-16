/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Usuarios;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface UsuariosService {
    
    //Interfaces para llamadas directas a base de datos
    public List<Usuarios> getListUsuarios();
    public boolean addUsuarios(Usuarios usuarios);
    public Usuarios getByIdUsuarios (Long id);
    public void deleteUsuarios (Long id);
    public boolean updateUsuarios (Usuarios usuarios);
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addUsuarioSP(Usuarios usuarios);
    public List<Usuarios> getByIdUsuarioSP(String run);
    public List<Usuarios> getAllUsuarioSP();
    public boolean updateUsuarioSP (Usuarios usuarios);
    public void deleteUsuarioSP(String run, Long estado);
}

