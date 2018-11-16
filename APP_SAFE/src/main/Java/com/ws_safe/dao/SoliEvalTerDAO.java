/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.SoliEvalTer;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface SoliEvalTerDAO {
    //Interfaces para llamadas directas a base de datos
    public List<SoliEvalTer> getListSoliEvalTer();
    public boolean addSoliEvalTer(SoliEvalTer soliEvalTer);
    public SoliEvalTer getByIdSoliEvalTer (Long id);
    public void deleteSoliEvalTer (Long id);
    public boolean updateSoliEvalTer (SoliEvalTer soliEvalTer);   
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addSoliEvalTerSP(SoliEvalTer soliEvalTer);
    public List<SoliEvalTer> getByIdSoliEvalTerSP(Long id);
    public List<SoliEvalTer> getAllSoliEvalTerSP();
    public boolean updateSoliEvalTerSP (SoliEvalTer soliEvalTer);
    public void deleteSoliEvalTerSP(Long id, Long estado);
}