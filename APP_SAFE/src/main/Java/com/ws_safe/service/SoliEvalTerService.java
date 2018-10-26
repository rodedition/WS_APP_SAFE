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
    public List<SoliEvalTer> getListSoliEvalTer();
    public boolean addSoliEvalTer(SoliEvalTer soliEvalTer);
    public SoliEvalTer getByIdSoliEvalTer (Long id);
    public void deleteSoliEvalTer (Long id);
    public boolean updateSoliEvalTer (SoliEvalTer soliEvalTer);
}

