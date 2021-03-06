/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.SoliEvalTerDAO;
import com.ws_safe.entity.SoliEvalTer;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("soliEvalTerService")
public class SoliEvalTerServiceImpl implements SoliEvalTerService{
    
    Logger logger = Logger.getLogger(SoliEvalTerServiceImpl.class);
    
    @Autowired
    @Qualifier("soliEvalTerDAO")
    
                
    SoliEvalTerDAO soliEvalTerDAOImpl;

       
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<SoliEvalTer> addSoliEvalTerSP(SoliEvalTer soliEvalTer) {
        return soliEvalTerDAOImpl.addSoliEvalTerSP(soliEvalTer);
    }

    @Override
    public List<SoliEvalTer> getByIdSoliEvalTerSP(Long id) {
        return soliEvalTerDAOImpl.getByIdSoliEvalTerSP(id);
    }

    @Override
    public List<SoliEvalTer> getAllSoliEvalTerSP() {
        return soliEvalTerDAOImpl.getAllSoliEvalTerSP();
    }

    @Override
    public boolean updateSoliEvalTerSP(SoliEvalTer soliEvalTer) {
        return soliEvalTerDAOImpl.updateSoliEvalTerSP(soliEvalTer);
    }

    @Override
    public void deleteSoliEvalTerSP(Long id, Long estado) {
        soliEvalTerDAOImpl.deleteSoliEvalTerSP(id, estado);
    }
    
    
}
