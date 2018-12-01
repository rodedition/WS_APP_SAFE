/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.List_Asis_SaludDao;
import com.ws_safe.entity.List_Asis_Salud;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("list_Asis_SaludService")
public class List_Asis_SaludServiceImpl implements List_Asis_SaludService{
    
    Logger logger = Logger.getLogger(List_Asis_SaludServiceImpl.class);
    
    @Autowired
    @Qualifier("list_Asis_SaludDao")
    
    List_Asis_SaludDao list_Asis_SaludDaoImpl;

    //Servicios para llamadas a PROCEDURE

    @Override
    public List<List_Asis_Salud> addList_Asis_SaludSP(List_Asis_Salud list_Asis_Salud) {
        return list_Asis_SaludDaoImpl.addList_Asis_SaludSP(list_Asis_Salud);
    }

    @Override
    public List<List_Asis_Salud> getByIdList_Asis_SaludSP(Long id) {
        return list_Asis_SaludDaoImpl.getByIdList_Asis_SaludSP(id);
    }

    @Override
    public List<List_Asis_Salud> getAllList_Asis_SaludSP() {
        return list_Asis_SaludDaoImpl.getAllList_Asis_SaludSP();
    }

    @Override
    public boolean updateList_Asis_SaludSP(List_Asis_Salud list_Asis_Salud) {
        return list_Asis_SaludDaoImpl.updateList_Asis_SaludSP(list_Asis_Salud);
    }

    @Override
    public void deleteList_Asis_SaludSP(Long id, Long estado) {
        list_Asis_SaludDaoImpl.deleteList_Asis_SaludSP(id, estado);
    }
    
    
    
}
