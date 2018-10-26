/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Sesion_CapDAO;
import com.ws_safe.entity.Sesion_Cap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("sesion_CapService")
public class Sesion_CapServiceImpl implements Sesion_CapService{
    
    Logger logger = Logger.getLogger(Sesion_CapServiceImpl.class);
    
    @Autowired
    @Qualifier("sesion_CapDAO")
    
    Sesion_CapDAO sesion_CapDAOImpl;

   
    public List<Sesion_Cap> getListSesion_Cap() {
        return sesion_CapDAOImpl.getListSesion_Cap();
    }

   
    public boolean addSesion_Cap(Sesion_Cap sesion_Cap) {
        return sesion_CapDAOImpl.addSesion_Cap(sesion_Cap);
    }

    public Sesion_Cap getByIdSesion_Cap(Long id) {
        return sesion_CapDAOImpl.getByIdSesion_Cap(id);
    }

    public void deleteSesion_Cap(Long id) {
        sesion_CapDAOImpl.deleteSesion_Cap(id);
    }

    public boolean updateSesion_Cap(Sesion_Cap sesion_Cap) {
        return sesion_CapDAOImpl.updateSesion_Cap(sesion_Cap);
    }    
    
}
