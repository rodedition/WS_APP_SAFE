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

    //Servicios para llamadas a PROCEDURE

    @Override
    public List<ListTrabSalud> addListTrabSaludSP(ListTrabSalud listTrabSalud) {
        return listTrabSaludDAOImpl.addListTrabSaludSP(listTrabSalud);
    }

    @Override
    public List<ListTrabSalud> getByIdListTrabSaludSP(Long id) {
        return listTrabSaludDAOImpl.getByIdListTrabSaludSP(id);
    }

    @Override
    public List<ListTrabSalud> getAllListTrabSaludSP() {
        return listTrabSaludDAOImpl.getAllListTrabSaludSP();
    }

    @Override
    public boolean updateListTrabSaludSP(ListTrabSalud listTrabSalud) {
        return listTrabSaludDAOImpl.updateListTrabSaludSP(listTrabSalud);
    }

    @Override
    public void deleteListTrabSaludSP(Long id, Long estado) {
        listTrabSaludDAOImpl.deleteListTrabSaludSP(id, estado);
    }
    
    
    
}
