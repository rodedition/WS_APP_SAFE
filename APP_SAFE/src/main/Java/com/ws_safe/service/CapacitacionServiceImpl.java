/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.CapacitacionDAO;
import com.ws_safe.entity.Capacitacion;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("capacitacionService")
public class CapacitacionServiceImpl implements CapacitacionService{
    
    Logger logger = Logger.getLogger(CapacitacionServiceImpl.class);
    
    @Autowired
    @Qualifier("capacitacionDAO")
    
    CapacitacionDAO capacitacionDAOImpl;

    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Capacitacion> addCapacitacionSP(Capacitacion capacitacion) {
        return capacitacionDAOImpl.addCapacitacionSP(capacitacion);
    }

    @Override
    public List<Capacitacion> getByIdCapacitacionSP(Long id) {
        return capacitacionDAOImpl.getByIdCapacitacionSP(id);
    }

    @Override
    public List<Capacitacion> getAllCapacitacionSP() {
        return capacitacionDAOImpl.getAllCapacitacionSP();
    }

    @Override
    public boolean updateCapacitacionSP(Capacitacion capacitacion) {
        return capacitacionDAOImpl.updateCapacitacionSP(capacitacion);
    }

    @Override
    public void deleteCapacitacionSP(Long id, Long estado) {
        capacitacionDAOImpl.deleteCapacitacionSP(id, estado);
    }
    
}
