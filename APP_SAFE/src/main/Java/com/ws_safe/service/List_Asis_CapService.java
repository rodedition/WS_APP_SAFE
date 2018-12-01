/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.List_Asis_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface List_Asis_CapService {
    
    //Interfaces para llamadas a PROCEDURE
    public List<List_Asis_Cap> addList_Asis_CapSP(List_Asis_Cap list_Asis_Cap);
    public List<List_Asis_Cap> getByIdList_Asis_CapSP(Long id);
    public List<List_Asis_Cap> getAllList_Asis_CapSP();
    public boolean updateList_Asis_CapSP (List_Asis_Cap list_Asis_Cap);
    public void deleteList_Asis_CapSP(Long id, Long estado);
}
