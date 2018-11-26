/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Expositor;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ExpositorService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Expositor> addExpositorSP(Expositor expositor);
    public List<Expositor> getByIdExpositorSP(Long id);
    public List<Expositor> getAllExpositoresSP();
    public boolean updateExpositorSP (Expositor expositor);
    public void deleteExpositorSP(Long id, Long estado);
}

