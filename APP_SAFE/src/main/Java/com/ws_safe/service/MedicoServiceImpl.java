/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.MedicoDAO;
import com.ws_safe.entity.Medico;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("medicoService")
public class MedicoServiceImpl implements MedicoService{
    
    Logger logger = Logger.getLogger(MedicoServiceImpl.class);
    
    @Autowired
    @Qualifier("medicoDAO")
    
    MedicoDAO medicoDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public List<Medico> addMedicoSP(Medico medico) {
        return medicoDAOImpl.addMedicoSP(medico);
    }

    @Override
    public List<Medico> getByIdMedicoSP(Long id) {
        return medicoDAOImpl.getByIdMedicoSP(id);
    }

    @Override
    public List<Medico> getAllMedicoSP() {
        return medicoDAOImpl.getAllMedicoSP();
    }

    @Override
    public boolean updateMedicoSP(Medico medico) {
        return medicoDAOImpl.updateMedicoSP(medico);
    }

    @Override
    public void deleteMedicoSP(Long id, Long estado) {
        medicoDAOImpl.deleteMedicoSP(id, estado);
    }
    
    
}
