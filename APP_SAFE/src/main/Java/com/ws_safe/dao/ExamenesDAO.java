/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Examenes;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ExamenesDAO {
      
    //Interfaces para llamadas a PROCEDURE
    public List<Examenes> addExamenSP(Examenes examenes);
    public List<Examenes> getByIdExamenSP(Long id);
    public List<Examenes> getAllExamenesSP();
    public boolean updateExamenSP (Examenes examenes);
    public void deleteExamenSP(Long id, Long estado);
}
