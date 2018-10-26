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
    public List<Expositor> getListExpositor();
    public boolean addExpositor(Expositor expositor);
    public Expositor getByIdExpositor (Long id);
    public void deleteExpositor (Long id);
    public boolean updateExpositor (Expositor expositor);   
}
