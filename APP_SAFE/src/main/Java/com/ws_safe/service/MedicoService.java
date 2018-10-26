/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Medico;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface MedicoService {
    public List<Medico> getListMedico();
    public boolean addMedico(Medico medico);
    public Medico getByIdMedico (Long id);
    public void deleteMedico (Long id);
    public boolean updateMedico (Medico medico);
}

