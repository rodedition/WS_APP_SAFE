/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.Tipo_ExaDAO;
import com.ws_safe.entity.Tipo_Exa;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */
@Service("tipo_ExaService")
public class Tipo_ExaServiceImpl implements Tipo_ExaService{
    
    Logger logger = Logger.getLogger(Tipo_ExaServiceImpl.class);
    
    @Autowired
    @Qualifier("tipo_ExaDAO")
    
    Tipo_ExaDAO tipo_exaDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Tipo_Exa> addTipoExaSP(Tipo_Exa tipo_Exa) {
        return tipo_exaDAOImpl.addTipoExaSP(tipo_Exa);
    }

    @Override
    public List<Tipo_Exa> getByIdTipoExaSP(Long id) {
        return tipo_exaDAOImpl.getByIdTipoExaSP(id);
    }

    @Override
    public List<Tipo_Exa> getAllTipoExaSP() {
        return tipo_exaDAOImpl.getAllTipoExaSP();
    }

    @Override
    public boolean updateTipoExaSP(Tipo_Exa tipo_Exa) {
        return tipo_exaDAOImpl.updateTipoExaSP(tipo_Exa);
    }

    @Override
    public void deleteTipoExaSP(Long id, Long estado) {
        tipo_exaDAOImpl.deleteTipoExaSP(id, estado);
    }

    
}
