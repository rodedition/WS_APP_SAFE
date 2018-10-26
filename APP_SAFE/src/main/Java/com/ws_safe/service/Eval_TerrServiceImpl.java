/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Eval_TerrDAO;
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

@Service("eval_terrService")
public class Eval_TerrServiceImpl implements Eval_TerrService{
    
    Logger logger = Logger.getLogger(Eval_TerrServiceImpl.class);
    
    @Autowired
    @Qualifier("eval_terrDAO")
    
    Eval_TerrDAO eval_TerrDAOImpl;

   
    public List<Eval_Terr> getListEval_Terr() {
        return eval_TerrDAOImpl.getListEval_Terr();
    }

   
    public boolean addEval_Terr(Eval_Terr eval_Terr) {
        return eval_TerrDAOImpl.addEval_Terr(eval_Terr);
    }

    public Eval_Terr getByIdEval_Terr(Long id) {
        return eval_TerrDAOImpl.getByIdEval_Terr(id);
    }

    public void deleteEval_Terr(Long id) {
        eval_TerrDAOImpl.deleteEval_Terr(id);
    }

    public boolean updateEval_Terr(Eval_Terr eval_Terr) {
        return eval_TerrDAOImpl.updateEval_Terr(eval_Terr);
    }    
    
}
