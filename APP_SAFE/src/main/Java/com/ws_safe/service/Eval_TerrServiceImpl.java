/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Eval_TerrDao;
import com.ws_safe.entity.Eval_Terr;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("eval_TerrService")
public class Eval_TerrServiceImpl implements Eval_TerrService{
    
    Logger logger = Logger.getLogger(Eval_TerrServiceImpl.class);
    
    @Autowired
    @Qualifier("eval_TerrDao")
    
    Eval_TerrDao eval_TerrDaoImpl;

   
    //Servicios para llamadas a PROCEDURE
    
    @Override
    public List<Eval_Terr> addEval_TerrSP(Eval_Terr eval_Terr) {
        return eval_TerrDaoImpl.addEval_TerrSP(eval_Terr);
    }
    
    @Override
    public List<Eval_Terr> getAllEval_TerrSP() {
        return eval_TerrDaoImpl.getAllEval_TerrSP();
    }
    
    public List<Eval_Terr> getByIdEval_TerrSP(Long id) {
        return eval_TerrDaoImpl.getByIdEval_TerrSP(id);
    }
    
    public boolean updateEval_TerrSP(Eval_Terr eval_Terr) {
        return eval_TerrDaoImpl.updateEval_TerrSP(eval_Terr);
    }

    public void deleteEval_TerrSP(Long id, Long estado) {
        eval_TerrDaoImpl.deleteEval_TerrSP(id, estado);
    }    
}
