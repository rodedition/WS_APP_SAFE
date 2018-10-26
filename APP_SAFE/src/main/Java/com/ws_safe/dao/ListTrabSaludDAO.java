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
    public List<ListTrabSalud> getListListTrabSalud();
    public boolean addListTrabSalud(ListTrabSalud listTrabSalud);
    public ListTrabSalud getByIdListTrabSalud (Long id);
    public void deleteListTrabSalud (Long id);
    public boolean updateListTrabSalud (ListTrabSalud listTrabSalud);   
}
