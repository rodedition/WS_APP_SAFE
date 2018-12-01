/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.List_Asis_CapDao;
import com.ws_safe.entity.List_Asis_Cap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("list_Asis_CapService")
public class List_Asis_CapServiceImpl implements List_Asis_CapService{
    
    Logger logger = Logger.getLogger(List_Asis_CapServiceImpl.class);
    
    @Autowired
    @Qualifier("list_Asis_CapDao")
    
    List_Asis_CapDao list_Asis_CapDaoImpl;

    //Servicios para llamadas a PROCEDURE

    @Override
    public List<List_Asis_Cap> addList_Asis_CapSP(List_Asis_Cap list_Asis_Cap) {
        return list_Asis_CapDaoImpl.addList_Asis_CapSP(list_Asis_Cap);
    }

    @Override
    public List<List_Asis_Cap> getByIdList_Asis_CapSP(Long id) {
        return list_Asis_CapDaoImpl.getByIdList_Asis_CapSP(id);
    }

    @Override
    public List<List_Asis_Cap> getAllList_Asis_CapSP() {
        return list_Asis_CapDaoImpl.getAllList_Asis_CapSP();
    }

    @Override
    public boolean updateList_Asis_CapSP(List_Asis_Cap list_Asis_Cap) {
        return list_Asis_CapDaoImpl.updateList_Asis_CapSP(list_Asis_Cap);
    }

    @Override
    public void deleteList_Asis_CapSP(Long id, Long estado) {
        list_Asis_CapDaoImpl.deleteList_Asis_CapSP(id, estado);
    }
    
    
    
}
