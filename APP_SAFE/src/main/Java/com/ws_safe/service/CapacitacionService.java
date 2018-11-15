/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Capacitacion;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface CapacitacionService {
    //Servicios para llamadas directas a base de datos
    public List<Capacitacion> getListCapacitacion();
    public boolean addCap(Capacitacion capacitacion);
    public Capacitacion getByIdCap (Long id);
    public void deleteCap (Long id);
    public boolean updateCap (Capacitacion capacitacion);
    
    //Servicios para llamadas a PROCEDURE
    public boolean addCapacitacionSP(Capacitacion capacitacion);
    public List<Capacitacion> getByIdCapacitacionSP(Long id);
    public List<Capacitacion> getAllCapacitacionSP();
    public boolean updateCapacitacionSP (Capacitacion capacitacion);
    public void deleteCapacitacionSP(Long id, Long estado);
}
