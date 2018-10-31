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

   
    public List<SoliEvalTer> getListSoliEvalTer() {
        return soliEvalTerDAOImpl.getListSoliEvalTer();
    }

   
    public boolean addSoliEvalTer(SoliEvalTer soliEvalTer) {
        return soliEvalTerDAOImpl.addSoliEvalTer(soliEvalTer);
    }

    public SoliEvalTer getByIdSoliEvalTer(Long id) {
        return soliEvalTerDAOImpl.getByIdSoliEvalTer(id);
    }

    public void deleteSoliEvalTer(Long id) {
        soliEvalTerDAOImpl.deleteSoliEvalTer(id);
    }

    public boolean updateSoliEvalTer(SoliEvalTer soliEvalTer) {
        return soliEvalTerDAOImpl.updateSoliEvalTer(soliEvalTer);
    }    
    
}