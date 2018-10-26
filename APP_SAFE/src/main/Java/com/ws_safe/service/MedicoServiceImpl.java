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

   
    public List<Medico> getListMedico() {
        return medicoDAOImpl.getListMedico();
    }

   
    public boolean addMedico(Medico medico) {
        return medicoDAOImpl.addMedico(medico);
    }

    public Medico getByIdMedico(Long id) {
        return medicoDAOImpl.getByIdMedico(id);
    }

    public void deleteMedico(Long id) {
        medicoDAOImpl.deleteMedico(id);
    }

    public boolean updateMedico(Medico medico) {
        return medicoDAOImpl.updateMedico(medico);
    }    
    
}
