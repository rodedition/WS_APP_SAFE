/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.ListTrabSalud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ListTrabSaludService {
    //Interfaces para llamadas directas a base de datos
    public List<ListTrabSalud> getListListTrabSalud();
    public boolean addListTrabSalud(ListTrabSalud listTrabSalud);
    public ListTrabSalud getByIdListTrabSalud (Long id);
    public void deleteListTrabSalud (Long id);
    public boolean updateListTrabSalud (ListTrabSalud listTrabSalud);
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addListTrabSaludSP(ListTrabSalud listTrabSalud);
    public List<ListTrabSalud> getByIdListTrabSaludSP(Long id);
    public List<ListTrabSalud> getAllListTrabSaludSP();
    public boolean updateListTrabSaludSP (ListTrabSalud listTrabSalud);
    public void deleteListTrabSaludSP(Long id, Long estado);
}

