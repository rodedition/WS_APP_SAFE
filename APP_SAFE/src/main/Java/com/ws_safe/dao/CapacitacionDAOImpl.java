/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Capacitacion;
import com.ws_safe.entity.Certificado;
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
@Repository("capacitacionDAO")
@Transactional
public class CapacitacionDAOImpl implements CapacitacionDAO{
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //Llamadas directas a base de datos
    
    @Override
    public List<Capacitacion> getListCapacitacion() {
        return (List<Capacitacion>)sessionFactory.getCurrentSession().createCriteria(Capacitacion.class).list();
    }
    
    @Override
    public boolean addCap(Capacitacion capacitacion) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().save(capacitacion);
        flagsave=true;
        
        return flagsave;
    }

    public Capacitacion getByIdCap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Capacitacion as c WHERE c.idcap=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Capacitacion)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCap(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete FROM Capacitacion as c WHERE c.idcap=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCap(Capacitacion capacitacion) {
        boolean flagsave = false;
        sessionFactory.getCurrentSession().update(capacitacion);
        flagsave=true;
        
        return flagsave;
    }   
    
    //Llamadas a procedures

    @Override
    public boolean addCapacitacionSP(Capacitacion capacitacion) {
        boolean flagsave = false;         
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL CapacitacionPKG.cap_agregar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, capacitacion.getIdcap());
                statement.setString(2, capacitacion.getNombrecapacitacion());
                statement.setLong(3, capacitacion.getEstadocapacitacion());
                statement.setLong(4, capacitacion.getPlancapidplancap());
                statement.setLong(5, capacitacion.getTipocapidtipocap());
                statement.executeUpdate();
            }
        });
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public List<Capacitacion> getByIdCapacitacionSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Capacitacion>>() {
            @Override
            public List<Capacitacion> execute(Connection connection) throws SQLException {
                String query = "{CALL CapacitacionPKG.cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Capacitacion> capacs;
                capacs = new ArrayList<Capacitacion>();
                while (rs.next()) {
                    Capacitacion capacitacion = new Capacitacion();
                    capacitacion.setIdcap(rs.getLong("ID_CAP"));
                    capacitacion.setNombrecapacitacion(rs.getString("NOMBRE_CAPACITACION"));
                    capacitacion.setEstadocapacitacion(rs.getLong("ESTADO_CAPACITACION"));
                    capacitacion.setPlancapidplancap(rs.getLong("PLAN_CAP_ID_PLAN_CAP"));
                    capacitacion.setTipocapidtipocap(rs.getLong("TIPO_CAP_ID_TIPO_CAP"));
                    capacs.add(capacitacion);
                }
                return capacs;
            }
        });
    }

    @Override
    public List<Capacitacion> getAllCapacitacionSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Capacitacion>>() {
            @Override
            public List<Capacitacion> execute(Connection connection) throws SQLException {
                String query = "{CALL CapacitacionPKG.All_capacitacion_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Capacitacion> capacs;
                capacs = new ArrayList<Capacitacion>();
                while (rs.next()) {
                    Capacitacion capacitacion = new Capacitacion();
                    capacitacion.setIdcap(rs.getLong("ID_CAP"));
                    capacitacion.setNombrecapacitacion(rs.getString("NOMBRE_CAPACITACION"));
                    capacitacion.setEstadocapacitacion(rs.getLong("ESTADO_CAPACITACION"));
                    capacitacion.setPlancapidplancap(rs.getLong("PLAN_CAP_ID_PLAN_CAP"));
                    capacitacion.setTipocapidtipocap(rs.getLong("TIPO_CAP_ID_TIPO_CAP"));
                    capacs.add(capacitacion);
                }
                return capacs;
            }
        });
    }

    @Override
    public boolean updateCapacitacionSP(Capacitacion capacitacion) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL CapacitacionPKG.cap_modificar(?, ?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, capacitacion.getNombrecapacitacion());
                statement.setLong(2, capacitacion.getEstadocapacitacion());
                statement.setLong(3, capacitacion.getPlancapidplancap());
                statement.setLong(4, capacitacion.getTipocapidtipocap());
                statement.setLong(4, capacitacion.getIdcap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteCapacitacionSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL CapacitacionPKG.cap_eliminar(:id_capacitacion, :estado_cap)").addEntity(Capacitacion.class).
        setParameter("id_capacitacion", id).setParameter("estado_cap", estado);        
        query.executeUpdate();
    }
}
