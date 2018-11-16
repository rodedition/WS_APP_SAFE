/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Sesion_Cap;
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
@Repository("sesion_CapDAO")
@Transactional
public class Sesion_CapDAOImpl implements Sesion_CapDAO{
    Logger logger = Logger.getLogger(Sesion_CapDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    //Llamadas directas a base de datos
        
    @Override
    public List<Sesion_Cap> getListSesion_Cap() {
        return (List<Sesion_Cap>)sessionFactory.getCurrentSession().createCriteria(Sesion_Cap.class).list();
    }
    
    @Override
    public boolean addSesion_Cap(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(sesion_Cap);
        flagsave=true;
        
        return flagsave;
    }

    public Sesion_Cap getByIdSesion_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Sesion_Cap as c WHERE c.idsesioncap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Sesion_Cap)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteSesion_Cap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Sesion_Cap as c WHERE c.idsesioncap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateSesion_Cap(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(sesion_Cap);
        flagsave=true;
        
        return flagsave;
    }
    
    //Llamadas a procedures

    @Override
    public boolean addSesionCapSP(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_CAP_PKG.sesion_cap_agregar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, sesion_Cap.getIdsesioncap());
                statement.setLong(2, sesion_Cap.getNumsesioncap());
                statement.setString(3, sesion_Cap.getNombresesion());
                statement.setLong(4, sesion_Cap.getCupossesion());
                statement.setString(5, sesion_Cap.getFechasesion());
                statement.setString(6, sesion_Cap.getHorainiciocap());
                statement.setString(7, sesion_Cap.getHoraterminocap());
                statement.setString(8, sesion_Cap.getDescripcionsesion());
                statement.setLong(9, sesion_Cap.getEstadosesioncap());
                statement.setLong(10, sesion_Cap.getCapacitacionidcap());
                statement.setLong(11, sesion_Cap.getExpositoridexpositor());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<Sesion_Cap> getByIdSesionCapSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Sesion_Cap>>() {
            @Override
            public List<Sesion_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_CAP_PKG.sesion_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Sesion_Cap> ses;
                ses = new ArrayList<Sesion_Cap>();
                while (rs.next()) {
                    Sesion_Cap sesion_Cap = new Sesion_Cap();
                    sesion_Cap.setIdsesioncap(rs.getLong("ID_SESION_CAP"));
                    sesion_Cap.setNumsesioncap(rs.getLong("NUM_SESION_CAP"));
                    sesion_Cap.setNombresesion(rs.getString("NOMBRE_SESION"));
                    sesion_Cap.setCupossesion(rs.getLong("CUPOS_SESION"));
                    sesion_Cap.setFechasesion(rs.getString("FECHA_SESION"));
                    sesion_Cap.setHorainiciocap(rs.getString("HORA_INICIO_CAP"));
                    sesion_Cap.setHoraterminocap(rs.getString("HORA_TERMINO_CAP"));
                    sesion_Cap.setDescripcionsesion(rs.getString("DESCRIPCION_SESION"));
                    sesion_Cap.setEstadosesioncap(rs.getLong("ESTADO"));
                    sesion_Cap.setCapacitacionidcap(rs.getLong("CAPACITACION_ID_CAP"));
                    sesion_Cap.setExpositoridexpositor(rs.getLong("EXPOSITOR_ID_EXPOSITOR"));
                    ses.add(sesion_Cap);
                }
                return ses;
            }
        });
    }

    @Override
    public List<Sesion_Cap> getAllSesionCapSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Sesion_Cap>>() {
            @Override
            public List<Sesion_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_CAP_PKG.All_sesion_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Sesion_Cap> ses;
                ses = new ArrayList<Sesion_Cap>();
                while (rs.next()) {
                    Sesion_Cap sesion_Cap = new Sesion_Cap();
                    sesion_Cap.setIdsesioncap(rs.getLong("ID_SESION_CAP"));
                    sesion_Cap.setNumsesioncap(rs.getLong("NUM_SESION_CAP"));
                    sesion_Cap.setNombresesion(rs.getString("NOMBRE_SESION"));
                    sesion_Cap.setCupossesion(rs.getLong("CUPOS_SESION"));
                    sesion_Cap.setFechasesion(rs.getString("FECHA_SESION"));
                    sesion_Cap.setHorainiciocap(rs.getString("HORA_INICIO_CAP"));
                    sesion_Cap.setHoraterminocap(rs.getString("HORA_TERMINO_CAP"));
                    sesion_Cap.setDescripcionsesion(rs.getString("DESCRIPCION_SESION"));
                    sesion_Cap.setEstadosesioncap(rs.getLong("ESTADO"));
                    sesion_Cap.setCapacitacionidcap(rs.getLong("CAPACITACION_ID_CAP"));
                    sesion_Cap.setExpositoridexpositor(rs.getLong("EXPOSITOR_ID_EXPOSITOR"));
                    ses.add(sesion_Cap);
                }
                return ses;
            }
        });
    }

    @Override
    public boolean updateSesionCapSP(Sesion_Cap sesion_Cap) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL SESION_CAP_PKG.sesion_cap_modificar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);               
                statement.setLong(1, sesion_Cap.getNumsesioncap());
                statement.setString(2, sesion_Cap.getNombresesion());
                statement.setLong(3, sesion_Cap.getCupossesion());
                statement.setString(4, sesion_Cap.getFechasesion());
                statement.setString(5, sesion_Cap.getHorainiciocap());
                statement.setString(6, sesion_Cap.getHoraterminocap());
                statement.setString(7, sesion_Cap.getDescripcionsesion());
                statement.setLong(8, sesion_Cap.getEstadosesioncap());
                statement.setLong(9, sesion_Cap.getCapacitacionidcap());
                statement.setLong(10, sesion_Cap.getExpositoridexpositor());
                statement.setLong(11, sesion_Cap.getIdsesioncap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteSesionCapSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL SESION_CAP_PKG.sesion_cap_eliminar(:id_ses_cap, :est_ses)").addEntity(Sesion_Cap.class).
        setParameter("id_ses_cap", id).setParameter("est_ses", estado);        
        query.executeUpdate();
    }
    
    
}
