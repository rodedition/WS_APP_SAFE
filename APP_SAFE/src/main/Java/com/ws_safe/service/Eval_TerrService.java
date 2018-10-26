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
    public List<Eval_Terr> getListEval_Terr();
    public boolean addEval_Terr(Eval_Terr eval_terr);
    public Eval_Terr getByIdEval_Terr (Long id);
    public void deleteEval_Terr (Long id);
    public boolean updateEval_Terr (Eval_Terr eval_terr);
}

