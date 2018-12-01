/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Cliente;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ClienteDAO {
    
    //Interfaces para llamadas a PROCEDURE
    public List<Cliente> addClienteSP(Cliente cliente);
    public List<Cliente> getByRutClienteSP(Cliente cliente);
    public List<Cliente> getByIdClienteSP(Long id);
    public List<Cliente> getAllClienteSP();
    public boolean updateClienteSP (Cliente cliente);
    public void deleteClienteSP(String rut, Long estado);
}
