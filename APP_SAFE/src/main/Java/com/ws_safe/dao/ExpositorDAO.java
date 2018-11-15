/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Expositor;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ExpositorDAO {
    //Interfaces para llamadas directas a base de datos
    public List<Expositor> getListExpositor();
    public boolean addExpositor(Expositor expositor);
    public Expositor getByIdExpositor (Long id);
    public void deleteExpositor (Long id);
    public boolean updateExpositor (Expositor expositor);  
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addExpositorSP(Expositor expositor);
    public List<Expositor> getByIdExpositorSP(Long id);
    public List<Expositor> getAllExpositoresSP();
    public boolean updateExpositorSP (Expositor expositor);
    public void deleteExpositorSP(Long id, Long estado);
}
