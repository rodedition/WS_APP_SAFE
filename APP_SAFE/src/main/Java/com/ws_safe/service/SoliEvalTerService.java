/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.SoliEvalTer;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface SoliEvalTerService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<SoliEvalTer> addSoliEvalTerSP(SoliEvalTer soliEvalTer);
    public List<SoliEvalTer> getByIdSoliEvalTerSP(Long id);
    public List<SoliEvalTer> getAllSoliEvalTerSP();
    public boolean updateSoliEvalTerSP (SoliEvalTer soliEvalTer);
    public void deleteSoliEvalTerSP(Long id, Long estado);
}

