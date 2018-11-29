/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Rodrigo
 */
@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl implements ClienteDAO{
    
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;   
    
    //Llamadas a procedures
     public List<Cliente> addClienteSP(Cliente cliente) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
              @Override
              public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL CLIENTEPKG.Cliente_Agregar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, cliente.getIdcliente());
                statement.setString(2, cliente.getRazonsocial());
                statement.setString(3, cliente.getRutcliente());
                statement.setString(4, cliente.getGirocliente());
                statement.setString(5, cliente.getDireccioncliente());
                statement.setString(6, cliente.getTeloficina());
                statement.setString(7, cliente.getNombrecontacto());
                statement.setString(8, cliente.getFonocontacto());
                statement.setString(9, cliente.getMailcontacto());
                statement.setString(10, cliente.getCargocontacto());
                statement.setString(11, cliente.getObservacionescliente());
                statement.setLong(12, cliente.getEstadocliente());
                statement.registerOutParameter(13, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(13);
                List<Cliente> clients;
                clients = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdcliente(rs.getLong("ID_CLIENTE"));
                    cliente.setRazonsocial(rs.getString("RAZON_SOCIAL"));
                    cliente.setRutcliente(rs.getString("RUT_CLIENTE"));
                    cliente.setGirocliente(rs.getString("GIRO_CLIENTE"));
                    cliente.setDireccioncliente(rs.getString("DIRECCION_CLIENTE"));
                    cliente.setTeloficina(rs.getString("TEL_OFICINA"));
                    cliente.setNombrecontacto(rs.getString("NOMBRE_CONTACTO"));
                    cliente.setFonocontacto(rs.getString("FONO_CONTACTO"));
                    cliente.setMailcontacto(rs.getString("MAIL_CONTACTO"));
                    cliente.setCargocontacto(rs.getString("CARGO_CONTACTO"));
                    cliente.setObservacionescliente(rs.getString("OBSERVACIONES_CLIENTE"));
                    cliente.setEstadocliente(rs.getLong("ESTADO_CLIENTE"));
                    clients.add(cliente);
                }
                return clients;
            }
        });
    }  
    
    
    public List<Cliente>getByIdClienteSP(String rut) {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
            @Override
            public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL CLIENTEPKG.Cliente_Consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setString(1, rut);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Cliente> clients;
                clients = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdcliente(rs.getLong("ID_CLIENTE"));
                    cliente.setRazonsocial(rs.getString("RAZON_SOCIAL"));
                    cliente.setRutcliente(rs.getString("RUT_CLIENTE"));
                    cliente.setGirocliente(rs.getString("GIRO_CLIENTE"));
                    cliente.setDireccioncliente(rs.getString("DIRECCION_CLIENTE"));
                    cliente.setTeloficina(rs.getString("TEL_OFICINA"));
                    cliente.setNombrecontacto(rs.getString("NOMBRE_CONTACTO"));
                    cliente.setFonocontacto(rs.getString("FONO_CONTACTO"));
                    cliente.setMailcontacto(rs.getString("MAIL_CONTACTO"));
                    cliente.setCargocontacto(rs.getString("CARGO_CONTACTO"));
                    cliente.setObservacionescliente(rs.getString("OBSERVACIONES_CLIENTE"));
                    cliente.setEstadocliente(rs.getLong("ESTADO_CLIENTE"));
                    clients.add(cliente);
                }
                return clients;
            }
        });
    }  
    
    public List<Cliente>getAllClienteSP() {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
            @Override
            public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL CLIENTEPKG.All_Cliente_Consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Cliente> clients;
                clients = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdcliente(rs.getLong("ID_CLIENTE"));
                    cliente.setRazonsocial(rs.getString("RAZON_SOCIAL"));
                    cliente.setRutcliente(rs.getString("RUT_CLIENTE"));
                    cliente.setGirocliente(rs.getString("GIRO_CLIENTE"));
                    cliente.setDireccioncliente(rs.getString("DIRECCION_CLIENTE"));
                    cliente.setTeloficina(rs.getString("TEL_OFICINA"));
                    cliente.setNombrecontacto(rs.getString("NOMBRE_CONTACTO"));
                    cliente.setFonocontacto(rs.getString("FONO_CONTACTO"));
                    cliente.setMailcontacto(rs.getString("MAIL_CONTACTO"));
                    cliente.setCargocontacto(rs.getString("CARGO_CONTACTO"));
                    cliente.setObservacionescliente(rs.getString("OBSERVACIONES_CLIENTE"));
                    cliente.setEstadocliente(rs.getLong("ESTADO_CLIENTE"));
                    clients.add(cliente);
                }
                return clients;
            }
        });
    }  
    
    @Override
    public boolean updateClienteSP(Cliente cliente) {
        boolean flagsave = false;
         //try {
              Session session = sessionFactory.getCurrentSession();
              //session.beginTransaction();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                //CallableStatement statement = null;
                String query = "{CALL CLIENTEPKG.Cliente_Modificar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, cliente.getRazonsocial());
                statement.setString(2, cliente.getRutcliente());
                statement.setString(3, cliente.getGirocliente());
                statement.setString(4, cliente.getDireccioncliente());
                statement.setString(5, cliente.getTeloficina());
                statement.setString(6, cliente.getNombrecontacto());
                statement.setString(7, cliente.getFonocontacto());
                statement.setString(8, cliente.getMailcontacto());
                statement.setString(9, cliente.getCargocontacto());
                statement.setString(10, cliente.getObservacionescliente());
                statement.setLong(11, cliente.getEstadocliente());
                statement.setLong(12, cliente.getIdcliente());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }
    
    public void deleteClienteSP(String rut, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.CLIENTE_ELIMINAR(:rut_cli, :est_cli)").addEntity(Cliente.class).
        setParameter("rut_cli", rut).setParameter("est_cli", estado);        
        query.executeUpdate();
    }

    
}   
   