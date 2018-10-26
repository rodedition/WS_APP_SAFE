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

   
    public List<Sesion_Salud> getListSesion_Salud() {
        return sesion_SaludDAOImpl.getListSesion_Salud();
    }

   
    public boolean addSesion_Salud(Sesion_Salud sesion_Salud) {
        return sesion_SaludDAOImpl.addSesion_Salud(sesion_Salud);
    }

    public Sesion_Salud getByIdSesion_Salud(Long id) {
        return sesion_SaludDAOImpl.getByIdSesion_Salud(id);
    }

    public void deleteSesion_Salud(Long id) {
        sesion_SaludDAOImpl.deleteSesion_Salud(id);
    }

    public boolean updateSesion_Salud(Sesion_Salud sesion_Salud) {
        return sesion_SaludDAOImpl.updateSesion_Salud(sesion_Salud);
    }    
    
}
