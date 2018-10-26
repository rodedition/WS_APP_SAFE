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

   
    public List<List_Trab_Cap> getListList_Trab_Cap() {
        return list_Trab_CapDAOImpl.getListList_Trab_Cap();
    }

   
    public boolean addList_Trab_Cap(List_Trab_Cap list_Trab_Cap) {
        return list_Trab_CapDAOImpl.addList_Trab_Cap(list_Trab_Cap);
    }

    public List_Trab_Cap getByIdList_Trab_Cap(Long id) {
        return list_Trab_CapDAOImpl.getByIdList_Trab_Cap(id);
    }

    public void deleteList_Trab_Cap(Long id) {
        list_Trab_CapDAOImpl.deleteList_Trab_Cap(id);
    }

    public boolean updateList_Trab_Cap(List_Trab_Cap list_Trab_Cap) {
        return list_Trab_CapDAOImpl.updateList_Trab_Cap(list_Trab_Cap);
    }    

    
}
