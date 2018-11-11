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
    
    //Interfaces para llamadas directas a base de datos
    public List<Cliente> getListCliente();
    public boolean addCliente(Cliente cliente);
    public Cliente getByIdCliente (Long id);
    public void deleteCliente (Long id);
    public boolean updateCliente (Cliente cliente);
    
    
    //Interfaces para llamadas a PROCEDURE
    public boolean addClienteSP(Cliente cliente);
    public List<Cliente> getByIdClienteSP(Long id);
    public List<Cliente> getAllClienteSP();
    public void deleteClienteSP(Long id, Long estado);
}
