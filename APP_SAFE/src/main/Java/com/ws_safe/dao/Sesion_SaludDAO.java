/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Salud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Sesion_SaludDAO {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Sesion_Salud> addSesionSaludSP(Sesion_Salud sesion_Salud);
    public List<Sesion_Salud> getByIdSesionSaludSP(Long id);
    public List<Sesion_Salud> getAllSesionSaludSP();
    public boolean updateSesionSaludSP (Sesion_Salud sesion_Salud);
    public void deleteSesionSaludSP(Long id, Long estado);
}
