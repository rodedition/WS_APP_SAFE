/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Examenes;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ExamenesService {
    //Interfaces Llamadas directas a base de datos
    public List<Examenes> getListExamen();
    public boolean addExamen(Examenes examenes);
    public Examenes getByIdExamen (Long id);
    public void deleteExamen (Long id);
    public boolean updateExamen (Examenes examenes);
    
    //Interfaces Llamadas a PROCEDURE
    public boolean addExamenSP(Examenes examenes);
    public List<Examenes> getByIdExamenSP(Long id);
    public List<Examenes> getAllExamenesSP();
    public boolean updateExamenSP (Examenes examenes);
    public void deleteExamenSP(Long id, Long estado);
}

