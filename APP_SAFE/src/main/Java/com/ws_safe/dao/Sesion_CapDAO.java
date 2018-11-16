/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Sesion_CapDAO {
    
    //Interfaces para llamadas directas a base de datos
    public List<Sesion_Cap> getListSesion_Cap();
    public boolean addSesion_Cap(Sesion_Cap sesion_Cap);
    public Sesion_Cap getByIdSesion_Cap (Long id);
    public void deleteSesion_Cap (Long id);
    public boolean updateSesion_Cap (Sesion_Cap sesion_Cap);   
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addSesionCapSP(Sesion_Cap sesion_Cap);
    public List<Sesion_Cap> getByIdSesionCapSP(Long id);
    public List<Sesion_Cap> getAllSesionCapSP();
    public boolean updateSesionCapSP (Sesion_Cap sesion_Cap);
    public void deleteSesionCapSP(Long id, Long estado);
}
