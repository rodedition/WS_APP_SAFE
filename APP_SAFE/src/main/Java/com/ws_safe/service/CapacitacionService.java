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
    public List<Capacitacion> getListCapacitacion();
    public boolean addCap(Capacitacion capacitacion);
    public Capacitacion getByIdCap (Long id);
    public void deleteCap (Long id);
    public boolean updateCap (Capacitacion capacitacion);
}
