/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.List_Trab_Cap;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface List_Trab_CapService {
    public List<List_Trab_Cap> getListList_Trab_Cap();
    public boolean addList_Trab_Cap(List_Trab_Cap list_Trab_Cap);
    public List_Trab_Cap getByIdList_Trab_Cap (Long id);
    public void deleteList_Trab_Cap (Long id);
    public boolean updateList_Trab_Cap (List_Trab_Cap list_Trab_Cap);
}

