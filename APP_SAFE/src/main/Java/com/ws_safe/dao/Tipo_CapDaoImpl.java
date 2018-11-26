/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Medico;
import com.ws_safe.entity.Tipo_Cap;
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
@Repository("tipo_CapDAO")
@Transactional
public class Tipo_CapDaoImpl implements Tipo_CapDAO{

    Logger logger = Logger.getLogger(Tipo_CapDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    //Llamadas a procedures
    
    @Override
    public List<Tipo_Cap> addTipoCapSP(Tipo_Cap tipo_cap) {
                
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Cap>>() {
              @Override
              public List<Tipo_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_CAP_PKG.tipo_cap_agregar(?, ?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);
                statement.setLong(1, tipo_cap.getIdtipocap());
                statement.setString(2, tipo_cap.getDescripcap());
                statement.setLong(3, tipo_cap.getEstado());
                statement.registerOutParameter(4, OracleTypes.CURSOR);                                
                statement.executeUpdate();   
                ResultSet rs = (ResultSet) statement.getObject(4);
                List<Tipo_Cap> tips;
                tips = new ArrayList<Tipo_Cap>();
                while (rs.next()) {
                    Tipo_Cap tipo_Cap = new Tipo_Cap();
                    tipo_Cap.setIdtipocap(rs.getLong("ID_TIPO_CAP"));
                    tipo_Cap.setDescripcap(rs.getString("DESCRIP_CAP"));
                    tipo_Cap.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Cap);
                    
                }
                return tips;
            }
        });
        
    }

    @Override
    public List<Tipo_Cap> getByIdTipoCapSP(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Cap>>() {
            @Override
            public List<Tipo_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_CAP_PKG.tipo_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, id);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Tipo_Cap> tips;
                tips = new ArrayList<Tipo_Cap>();
                while (rs.next()) {
                    Tipo_Cap tipo_Cap = new Tipo_Cap();
                    tipo_Cap.setIdtipocap(rs.getLong("ID_TIPO_CAP"));
                    tipo_Cap.setDescripcap(rs.getString("DESCRIP_CAP"));
                    tipo_Cap.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Cap);
                }
                return tips;
            }
        });
    }

    @Override
    public List<Tipo_Cap> getAllTipoCapSP() {
        Session session = sessionFactory.getCurrentSession();
        return session.doReturningWork(new ReturningWork<List<Tipo_Cap>>() {
            @Override
            public List<Tipo_Cap> execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_CAP_PKG.All_tipo_cap_consultar(?, ?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setLong(1, 1L);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(2);
                List<Tipo_Cap> tips;
                tips = new ArrayList<Tipo_Cap>();
                while (rs.next()) {
                    Tipo_Cap tipo_Cap = new Tipo_Cap();
                    tipo_Cap.setIdtipocap(rs.getLong("ID_TIPO_CAP"));
                    tipo_Cap.setDescripcap(rs.getString("DESCRIP_CAP"));
                    tipo_Cap.setEstado(rs.getLong("ESTADO"));
                    tips.add(tipo_Cap);
                }
                return tips;
            }
        });
    }

    @Override
    public boolean updateTipoCapSP(Tipo_Cap tipo_cap) {
        boolean flagsave = false;
              Session session = sessionFactory.getCurrentSession();
              session.doWork(new Work() {
              @Override
              public void execute(Connection connection) throws SQLException {
                String query = "{CALL TIPO_CAP_PKG.tipo_cap_modificar(?, ?, ?)}";
                CallableStatement statement = connection.prepareCall(query);                
                statement.setString(1, tipo_cap.getDescripcap());
                statement.setLong(2, tipo_cap.getEstado());
                statement.setLong(3, tipo_cap.getIdtipocap());
                statement.executeUpdate();
            }
        });        
       
        flagsave=true;
        return flagsave;
    }

    @Override
    public void deleteTipoCapSP(Long id, Long estado) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL TIPO_CAP_PKG.tipo_cap_eliminar(:id_tipo_capacitacion, :est_tipo_cap)").addEntity(Tipo_Cap.class).
        setParameter("id_tipo_capacitacion", id).setParameter("est_tipo_cap", estado);        
        query.executeUpdate();
    }
    
}
