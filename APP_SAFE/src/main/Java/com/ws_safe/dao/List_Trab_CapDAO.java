/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.List_Trab_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface List_Trab_CapDAO {
    
    //Interfaces para llamadas a PROCEDURE
    public List<List_Trab_Cap> addListTrabCapSP(List_Trab_Cap list_Trab_Cap);
    public List<List_Trab_Cap> getByIdListTrabCapSP(Long id);
    public List<List_Trab_Cap> getAllListTrabCapSP();
    public boolean updateListTrabCapSP (List_Trab_Cap list_Trab_Cap);
    public void deleteListTrabCapSP(Long id, Long estado);
}
