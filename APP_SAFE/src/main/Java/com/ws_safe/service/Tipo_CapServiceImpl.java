/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Tipo_CapDAO;
import com.ws_safe.entity.Tipo_Cap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */
@Service("tipo_CapService")
public class Tipo_CapServiceImpl implements Tipo_CapService{
    
    Logger logger = Logger.getLogger(Tipo_CapServiceImpl.class);
    
    @Autowired
    @Qualifier("tipo_CapDAO")
    
    Tipo_CapDAO tipo_capDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Tipo_Cap> addTipoCapSP(Tipo_Cap tipo_cap) {
        return tipo_capDAOImpl.addTipoCapSP(tipo_cap);
    }

    @Override
    public List<Tipo_Cap> getByIdTipoCapSP(Long id) {
        return tipo_capDAOImpl.getByIdTipoCapSP(id);
    }

    @Override
    public List<Tipo_Cap> getAllTipoCapSP() {
        return tipo_capDAOImpl.getAllTipoCapSP();
    }

    @Override
    public boolean updateTipoCapSP(Tipo_Cap tipo_cap) {
        return tipo_capDAOImpl.updateTipoCapSP(tipo_cap);
    }

    @Override
    public void deleteTipoCapSP(Long id, Long estado) {
        tipo_capDAOImpl.deleteTipoCapSP(id, estado);
    }
    
}
