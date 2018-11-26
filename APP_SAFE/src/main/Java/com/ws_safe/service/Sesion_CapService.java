/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Sesion_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Sesion_CapService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Sesion_Cap> addSesionCapSP(Sesion_Cap sesion_Cap);
    public List<Sesion_Cap> getByIdSesionCapSP(Long id);
    public List<Sesion_Cap> getAllSesionCapSP();
    public boolean updateSesionCapSP (Sesion_Cap sesion_Cap);
    public void deleteSesionCapSP(Long id, Long estado);
}

