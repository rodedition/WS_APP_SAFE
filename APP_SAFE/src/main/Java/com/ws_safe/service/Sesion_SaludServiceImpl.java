/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Sesion_SaludDAO;
import com.ws_safe.entity.Sesion_Salud;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("sesion_SaludService")
public class Sesion_SaludServiceImpl implements Sesion_SaludService{
    
    Logger logger = Logger.getLogger(Sesion_SaludServiceImpl.class);
    
    @Autowired
    @Qualifier("sesion_SaludDAO")
    
    Sesion_SaludDAO sesion_SaludDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Sesion_Salud> addSesionSaludSP(Sesion_Salud sesion_Salud) {
        return sesion_SaludDAOImpl.addSesionSaludSP(sesion_Salud);
    }

    @Override
    public List<Sesion_Salud> getByIdSesionSaludSP(Long id) {
        return sesion_SaludDAOImpl.getByIdSesionSaludSP(id);
    }

    @Override
    public List<Sesion_Salud> getAllSesionSaludSP() {
        return sesion_SaludDAOImpl.getAllSesionSaludSP();
    }

    @Override
    public boolean updateSesionSaludSP(Sesion_Salud sesion_Salud) {
        return sesion_SaludDAOImpl.updateSesionSaludSP(sesion_Salud);
    }

    @Override
    public void deleteSesionSaludSP(Long id, Long estado) {
        sesion_SaludDAOImpl.deleteSesionSaludSP(id, estado);
    }
    
    
}
