/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Eval_Terr;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Eval_TerrService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Eval_Terr> addEval_TerrSP(Eval_Terr eval_Terr);
    public List<Eval_Terr> getByIdEval_TerrSP(Long id);
    public List<Eval_Terr> getAllEval_TerrSP();
    public boolean updateEval_TerrSP (Eval_Terr eval_Terr);
    public void deleteEval_TerrSP(Long id, Long estado);
}
