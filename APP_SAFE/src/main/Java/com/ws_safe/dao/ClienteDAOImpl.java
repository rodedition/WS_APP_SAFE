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
    
    //Llamadas directas a base de datos
    @Override
    public List<Cliente> getListCliente() {
        return (List<Cliente>)sessionFactory.getCurrentSession().createCriteria(Cliente.class).list();
    }
    
    @Override
    public boolean addCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(cliente);
        flagsave=true;
        
        return flagsave;
    }

    public Cliente getByIdCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCliente(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCliente(Cliente cliente) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(cliente);
        flagsave=true;
        
        return flagsave;
    }
    
    //Llamadas a procedures
    
    public boolean addClienteSP(Cliente cliente) {
        boolean flagsave = false;
        
            Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.Cliente_Agregar(:id_cli, :raz_soc, :rut_cli, :giro_cli, :dir_cli, :tel_of, :nom_contacto, :fn_contacto, :correo_Contacto, :cargo, :obs, :est_cli)").addEntity(Cliente.class)
            .setParameter("id_cli", cliente.getIdcliente())
            .setParameter("raz_soc", cliente.getRazonsocial())
            .setParameter("rut_cli", cliente.getRutcliente())
            .setParameter("giro_cli", cliente.getGirocliente())
            .setParameter("dir_cli", cliente.getDireccioncliente())
            .setParameter("tel_of", cliente.getTeloficina())
            .setParameter("nom_contacto", cliente.getNombrecontacto())
            .setParameter("fn_contacto", cliente.getFonocontacto())
            .setParameter("correo_Contacto", cliente.getMailcontacto())
            .setParameter("cargo", cliente.getCargocontacto())
            .setParameter("obs", cliente.getObservacionescliente())
            .setParameter("est_cli", cliente.getEstadocliente());
            query.executeUpdate();
        
        flagsave=true;
        return flagsave;
    }
    
    public List<Cliente>getByIdClienteSP(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
            @Override
            public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL CLIENTEPKG.Cliente_Consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
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
    
    public void deleteClienteSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CLIENTEPKG.CLIENTE_ELIMINAR(:id_cli, :est_cli)").addEntity(Cliente.class).
        setParameter("id_cli", id).setParameter("est_cli", estado);        
        query.executeUpdate();
    }
}   
   