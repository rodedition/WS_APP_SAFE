/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Tipo_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Tipo_CapService {
    //Interfaces para llamadas a PROCEDURE
    public List<Tipo_Cap> addTipoCapSP(Tipo_Cap tipo_cap);
    public List<Tipo_Cap> getByIdTipoCapSP(Long id);
    public List<Tipo_Cap> getAllTipoCapSP();
    public boolean updateTipoCapSP (Tipo_Cap tipo_cap);
    public void deleteTipoCapSP(Long id, Long estado);
}
