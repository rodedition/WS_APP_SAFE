/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Examenes;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ExamenesService {
    public List<Examenes> getListExamen();
    public boolean addExamen(Examenes examenes);
    public Examenes getByIdExamen (Long id);
    public void deleteExamen (Long id);
    public boolean updateExamen (Examenes examenes);
}

