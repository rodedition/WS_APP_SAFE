/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.ListTrabSaludDAO;
import com.ws_safe.entity.ListTrabSalud;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("listTrabSaludService")
public class ListTrabSaludServiceImpl implements ListTrabSaludService{
    
    Logger logger = Logger.getLogger(ListTrabSaludServiceImpl.class);
    
    @Autowired
    @Qualifier("listTrabSaludDAO")
    
    ListTrabSaludDAO listTrabSaludDAOImpl;

   
    public List<ListTrabSalud> getListListTrabSalud() {
        return listTrabSaludDAOImpl.getListListTrabSalud();
    }

   
    public boolean addListTrabSalud(ListTrabSalud listTrabSalud) {
        return listTrabSaludDAOImpl.addListTrabSalud(listTrabSalud);
    }

    public ListTrabSalud getByIdListTrabSalud(Long id) {
        return listTrabSaludDAOImpl.getByIdListTrabSalud(id);
    }

    public void deleteListTrabSalud(Long id) {
        listTrabSaludDAOImpl.deleteListTrabSalud(id);
    }

    public boolean updateListTrabSalud(ListTrabSalud listTrabSalud) {
        return listTrabSaludDAOImpl.updateListTrabSalud(listTrabSalud);
    }    
    
}
