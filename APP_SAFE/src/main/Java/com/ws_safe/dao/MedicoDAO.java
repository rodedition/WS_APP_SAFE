/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Medico;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface MedicoDAO {
    //Interfaces para llamadas a PROCEDURE
    public List<Medico> addMedicoSP(Medico medico);
    public List<Medico> getByIdMedicoSP(Long id);
    public List<Medico> getAllMedicoSP();
    public boolean updateMedicoSP (Medico medico);
    public void deleteMedicoSP(Long id, Long estado);
}
