/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Tipo_Exa;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Tipo_ExaDAO {
    //Interfaces para llamadas a PROCEDURE
    public List<Tipo_Exa> addTipoExaSP(Tipo_Exa tipo_Exa);
    public List<Tipo_Exa> getByIdTipoExaSP(Long id);
    public List<Tipo_Exa> getAllTipoExaSP();
    public boolean updateTipoExaSP (Tipo_Exa tipo_Exa);
    public void deleteTipoExaSP(Long id, Long estado);
}
