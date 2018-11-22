/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.List_Trab_CapDAO;
import com.ws_safe.entity.List_Trab_Cap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("list_Trab_CapService")
public class List_Trab_CapServiceImpl implements List_Trab_CapService{
    
    Logger logger = Logger.getLogger(List_Trab_CapServiceImpl.class);
    
    @Autowired
    @Qualifier("list_Trab_CapDAO")
    
    List_Trab_CapDAO list_Trab_CapDAOImpl;
    
    //Servicios para llamadas a PROCEDURE

    @Override
    public boolean addListTrabCapSP(List_Trab_Cap list_Trab_Cap) {
        return list_Trab_CapDAOImpl.addListTrabCapSP(list_Trab_Cap);
    }

    @Override
    public List<List_Trab_Cap> getByIdListTrabCapSP(Long id) {
        return list_Trab_CapDAOImpl.getByIdListTrabCapSP(id);
    }

    @Override
    public List<List_Trab_Cap> getAllListTrabCapSP() {
        return list_Trab_CapDAOImpl.getAllListTrabCapSP();
    }

    @Override
    public boolean updateListTrabCapSP(List_Trab_Cap list_Trab_Cap) {
        return list_Trab_CapDAOImpl.updateListTrabCapSP(list_Trab_Cap);
    }

    @Override
    public void deleteListTrabCapSP(Long id, Long estado) {
        list_Trab_CapDAOImpl.deleteListTrabCapSP(id, estado);
    }
    
    
}
