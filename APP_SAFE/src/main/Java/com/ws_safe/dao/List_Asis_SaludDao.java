/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Asis_Salud;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface List_Asis_SaludDao {
    
    //Interfaces para llamadas a PROCEDURE
    public List<List_Asis_Salud> addList_Asis_SaludSP(List_Asis_Salud list_Asis_Salud);
    public List<List_Asis_Salud> getByIdList_Asis_SaludSP(Long id);
    public List<List_Asis_Salud> getAllList_Asis_SaludSP();
    public boolean updateList_Asis_SaludSP (List_Asis_Salud list_Asis_Salud);
    public void deleteList_Asis_SaludSP(Long id, Long estado);
}
