/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.ListTrabSalud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ListTrabSaludDAO {
    //Interfaces para llamadas a PROCEDURE
    public List<ListTrabSalud> addListTrabSaludSP(ListTrabSalud listTrabSalud);
    public List<ListTrabSalud> getByIdListTrabSaludSP(Long id);
    public List<ListTrabSalud> getAllListTrabSaludSP();
    public boolean updateListTrabSaludSP (ListTrabSalud listTrabSalud);
    public void deleteListTrabSaludSP(Long id, Long estado);
}
