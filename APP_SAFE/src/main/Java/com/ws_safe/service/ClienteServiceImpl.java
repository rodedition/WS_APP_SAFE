/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.ClienteDAO;
import com.ws_safe.entity.Cliente;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{
    
    Logger logger = Logger.getLogger(ClienteServiceImpl.class);
    
    @Autowired
    @Qualifier("clienteDAO")
    
    ClienteDAO clienteDAOImpl;

   //Servicios para llamadas a base de datos directa
    
    public List<Cliente> getListCliente() {
        return clienteDAOImpl.getListCliente();
    }

   
    public boolean addCliente(Cliente cliente) {
        return clienteDAOImpl.addCliente(cliente);
    }

    public Cliente getByIdCliente(Long id) {
        return clienteDAOImpl.getByIdCliente(id);
    }

    public void deleteCliente(Long id) {
        clienteDAOImpl.deleteCliente(id);
    }

    public boolean updateCliente(Cliente cliente) {
        return clienteDAOImpl.updateCliente(cliente);
    }

    //Servicios para llamadas a PROCEDURE
    
    @Override
    public boolean addClienteSP(Cliente cliente) {
        return clienteDAOImpl.addClienteSP(cliente);
    }
    
    @Override
    public List<Cliente> getAllClienteSP() {
        return clienteDAOImpl.getAllClienteSP();
    }
    
    public List<Cliente> getByIdClienteSP(Long id) {
        return clienteDAOImpl.getByIdClienteSP(id);
    }
    
    public boolean updateClienteSP(Cliente cliente) {
        return clienteDAOImpl.updateCliente(cliente);
    }

    public void deleteClienteSP(Long id, Long estado) {
        clienteDAOImpl.deleteClienteSP(id, estado);
    }    
}
