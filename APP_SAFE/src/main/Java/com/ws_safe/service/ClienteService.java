/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.entity.Cliente;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface ClienteService {
    
    //Interfaces Llamadas directas a base de datos
    public List<Cliente> getListCliente();
    public boolean addCliente(Cliente cliente);
    public Cliente getByIdCliente (Long id);
    public void deleteCliente (Long id);
    public boolean updateCliente (Cliente cliente);
    
    //Interfaces Llamadas a PROCEDURE
    public boolean addClienteSP(Cliente cliente);
    public List<Cliente> getByIdClienteSP(Long id);
    public List<Cliente> getAllClienteSP();
    public boolean updateClienteSP (Cliente cliente);
    public void deleteClienteSP(Long id, Long estado);
}
